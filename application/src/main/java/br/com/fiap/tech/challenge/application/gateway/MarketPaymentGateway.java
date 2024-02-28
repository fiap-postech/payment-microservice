package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

import java.util.Optional;

public interface MarketPaymentGateway {

    Optional<String> pay(Purchase purchase);

    Optional<String> getPurchaseUUID(String marketPaymentId);
}
