package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.adapter.producer.PurchaseProducer;
import br.com.fiap.tech.challenge.application.dto.PaymentConfirmDTO;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentConfirmUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PaymentConfirmControllerImpl implements PaymentConfirmController {

    private final PaymentConfirmUseCase useCase;
    private final PurchasePresenter presenter;
    private final PurchaseProducer purchaseProducer;

    @Override
    public PurchaseDTO confirm(PaymentConfirmDTO dto) {
        var purchaseDTO = presenter.present(useCase.confirm(dto));
        purchaseProducer.doneEvent(purchaseDTO);
        return purchaseDTO;
    }
}
