package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.adapter.presenter.PaymentPresenter;
import br.com.fiap.tech.challenge.adapter.producer.PaymentProducer;
import br.com.fiap.tech.challenge.application.dto.PaymentConfirmDTO;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentConfirmUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PaymentConfirmControllerImpl implements PaymentConfirmController {

    private final PaymentConfirmUseCase useCase;
    private final PaymentPresenter presenter;
    private final PaymentProducer paymentProducer;

    @Override
    public PaymentDTO confirm(PaymentConfirmDTO dto) {
        var paymentDTO = presenter.present(useCase.confirm(dto));
        paymentProducer.doneEvent(paymentDTO);
        return paymentDTO;
    }
}
