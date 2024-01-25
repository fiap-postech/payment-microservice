package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.adapter.producer.PurchaseProducer;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentConfirmUseCase;
import br.com.fiap.tech.challenge.application.usecase.payment.PurchaseUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseControllerFactory {

    public static PurchaseController createPurchaseController(PurchaseUseCase useCase) {
        return new PurchaseControllerImpl(useCase);
    }

    public static PaymentConfirmController paymentConfirmController(PaymentConfirmUseCase useCase, PurchasePresenter presenter, PurchaseProducer producer) {
        return new PaymentConfirmControllerImpl(useCase, presenter, producer);
    }
}
