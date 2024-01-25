package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.PaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseUseCaseFactory {

    public static PurchaseUseCase createPurchaseUseCase(PaymentGateway paymentGateway, PaymentWriterGateway paymentWriterGateway) {
        return new PurchaseUseCaseImpl(paymentGateway, paymentWriterGateway);
    }


    public static UpdatePurchaseStatusUseCase updatePurchaseUseCase(PaymentWriterGateway gateway) {
        return new UpdatePurchaseStatusUseCaseImpl(gateway);
    }

    public static FindPurchaseByPaymentIdUseCase findPurchaseByPaymentIdUseCase(PaymentGateway paymentGateway, PaymentReaderGateway paymentReaderGateway) {
        return new FindPurchaseByPaymentIdUseCaseImpl(paymentGateway, paymentReaderGateway);
    }

    public static PaymentConfirmUseCase paymentConfirmUseCase(FindPurchaseByPaymentIdUseCase findPurchaseUseCase, UpdatePurchaseStatusUseCase updatePurchaseStatusUseCase) {
        return new PaymentConfirmUseCaseImpl(findPurchaseUseCase, updatePurchaseStatusUseCase);
    }
}
