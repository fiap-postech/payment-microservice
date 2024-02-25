package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.MarketPaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentMethod;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.Money;

import java.time.LocalDate;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PAYMENT_ERROR;
import static br.com.fiap.tech.challenge.util.MoneyConstants.CURRENCY_CODE;

@RequiredArgsConstructor
public class PaymentUseCaseImpl implements PaymentUseCase {

    private final MarketPaymentGateway marketPaymentGateway;
    private final PaymentWriterGateway paymentWriterGateway;


    @Override
    public Payment create(Purchase purchase) {
        purchase.setPaymentMethod(PaymentMethod.PAID_MARKET);
        var payment = createPayment(purchase, doPayment(purchase));
        return paymentWriterGateway.write(payment);
    }

    private String doPayment(Purchase purchase) {
        var paymentUrlOpt = marketPaymentGateway.pay(purchase);

        if (paymentUrlOpt.isEmpty()) {
            throw new ApplicationException(PAYMENT_ERROR);
        }
        return paymentUrlOpt.get();
    }

    private Payment createPayment(Purchase purchase, String paymentUrl) {
        return Payment.builder()
                .status(PaymentStatus.CREATED)
                .purchaseId(purchase.uuid().toString())
                .date(LocalDate.now())
                .method(PaymentMethod.PAID_MARKET)
                .amount(Money.of(purchase.total(), CURRENCY_CODE))
                .paymentUrl(paymentUrl)
                .build();
    }
}
