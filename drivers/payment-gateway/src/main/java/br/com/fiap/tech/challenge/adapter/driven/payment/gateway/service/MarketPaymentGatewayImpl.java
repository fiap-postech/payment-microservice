package br.com.fiap.tech.challenge.adapter.driven.payment.gateway.service;

import br.com.fiap.tech.challenge.application.dto.MarketPaymentDTO;
import br.com.fiap.tech.challenge.application.gateway.MarketPaymentGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MarketPaymentGatewayImpl implements MarketPaymentGateway {

    private final BeanFactory factory;

    @Override
    public Optional<String> pay(Purchase purchase) {
        return current(purchase.paymentMethod()).pay(purchase);
    }

    @Override
    public Optional<MarketPaymentDTO> getPurchaseUUID(String marketPaymentId) {
        return current(PaymentMethod.PAID_MARKET).getPurchaseUUID(marketPaymentId);
    }

    private br.com.fiap.tech.challenge.adapter.driven.payment.gateway.service.PaymentGateway current(PaymentMethod method) {
        return factory.getBeanProvider(br.com.fiap.tech.challenge.adapter.driven.payment.gateway.service.PaymentGateway.class)
                .stream()
                .filter(pq -> pq.accept(method))
                .findFirst()
                .orElseThrow();
    }


}
