package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UpdatePaymentStatusUseCaseImpl implements UpdatePaymentStatusUseCase {

    private final PaymentWriterGateway gateway;

    @Override
    public Payment update(Payment payment, PaymentStatus status) {

        var updatedPayment = switch (status) {
            case CREATED -> payment;
            case PAID -> payment.paid();
            case ERROR -> payment.error();
        };

        return gateway.write(updatedPayment);
    }
}
