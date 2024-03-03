package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.presenter.PaymentPresenter;
import br.com.fiap.tech.challenge.adapter.producer.PaymentProducer;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentConfirmUseCase;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseControllerFactory {

    public static PaymentController createPurchaseController(PaymentUseCase useCase) {
        return new PaymentControllerImpl(useCase);
    }

    public static PaymentConfirmController paymentConfirmController(PaymentConfirmUseCase useCase, PaymentPresenter presenter, PaymentProducer producer) {
        return new PaymentConfirmControllerImpl(useCase, presenter, producer);
    }
}
