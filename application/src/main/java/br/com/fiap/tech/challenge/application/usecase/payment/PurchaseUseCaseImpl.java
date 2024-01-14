package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.PaymentGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Cart;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentMethod;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PAYMENT_ERROR;

@RequiredArgsConstructor
public class PurchaseUseCaseImpl implements PurchaseUseCase {

    private final PaymentGateway paymentGateway;


    @Override
    public Purchase create(Cart cart) {
        var payment = createPayment(cart);
        var purchase = Purchase.newPurchase(cart, payment);

        var urlPayment = doPayment(purchase);
        purchase.payment().setUrlPayment(urlPayment);

        return purchase;
    }

    private String doPayment(Purchase purchase) {
        var urlPaymentOpt = paymentGateway.pay(purchase);

        if (urlPaymentOpt.isEmpty()) {
            throw new ApplicationException(PAYMENT_ERROR);
        }
        return urlPaymentOpt.get();
    }

    private Payment createPayment(Cart cart) {
        return Payment.builder()
                .status(PaymentStatus.CREATED)
                .date(LocalDate.now())
                .method(PaymentMethod.PAID_MARKET)
                .amount(cart.total().amount())
                .build();
    }
}
