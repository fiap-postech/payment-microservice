package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.MarketPaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseUseCaseFactory {

    public static PaymentUseCase createPurchaseUseCase(MarketPaymentGateway marketPaymentGateway, PaymentWriterGateway paymentWriterGateway) {
        return new PaymentUseCaseImpl(marketPaymentGateway, paymentWriterGateway);
    }


    public static UpdatePaymentStatusUseCase updatePurchaseUseCase(PaymentWriterGateway gateway) {
        return new UpdatePaymentStatusUseCaseImpl(gateway);
    }

    public static FindPaymentByMarketPaymentIdUseCase findPurchaseByPaymentIdUseCase(PaymentReaderGateway paymentReaderGateway, MarketPaymentGateway marketPaymentGateway) {
        return new FindPaymentByMarketPaymentIdUseCaseImpl(paymentReaderGateway, marketPaymentGateway);
    }

    public static PaymentConfirmUseCase paymentConfirmUseCase(FindPaymentByMarketPaymentIdUseCase findPurchaseUseCase, UpdatePaymentStatusUseCase updatePaymentStatusUseCase) {
        return new PaymentConfirmUseCaseImpl(findPurchaseUseCase, updatePaymentStatusUseCase);
    }
}
