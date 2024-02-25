package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus;

public interface UpdatePaymentStatusUseCase {

    Payment update(Payment payment, PaymentStatus status);
}
