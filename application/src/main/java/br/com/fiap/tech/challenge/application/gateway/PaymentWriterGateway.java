package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.Payment;

public interface PaymentWriterGateway {
    Payment write(Payment payment);
}
