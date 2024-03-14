package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.dto.PaymentConfirmDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PaymentConfirmUseCaseImpl implements PaymentConfirmUseCase {

    private final FindPaymentByMarketPaymentIdUseCase findPaymentByMarketPaymentIdUseCase;
    private final UpdatePaymentStatusUseCase updatePaymentStatusUseCase;

    @Override
    public Payment confirm(PaymentConfirmDTO dto) {
        var payment = findPaymentByMarketPaymentIdUseCase.getPayment(dto.getData().getId());
        return updatePaymentStatusUseCase.update(payment, payment.status());
    }
}
