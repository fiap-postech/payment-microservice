package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.application.usecase.payment.PurchaseUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseControllerFactory {

    public static PurchaseController createPurchaseController(PurchaseUseCase useCase) {
        return new PurchaseControllerImpl(useCase);
    }
}
