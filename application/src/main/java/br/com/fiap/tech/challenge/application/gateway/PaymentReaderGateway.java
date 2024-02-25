package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.Payment;

import java.util.UUID;

public interface PaymentReaderGateway {

    Payment readById(UUID id);
}
