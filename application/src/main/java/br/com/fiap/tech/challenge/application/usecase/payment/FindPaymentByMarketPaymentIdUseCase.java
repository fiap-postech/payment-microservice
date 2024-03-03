package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.enterprise.entity.Payment;

public interface FindPaymentByMarketPaymentIdUseCase {
    Payment getPayment(String marketPaymentId);
}
