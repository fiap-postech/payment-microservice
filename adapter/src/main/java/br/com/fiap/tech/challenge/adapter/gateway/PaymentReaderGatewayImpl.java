package br.com.fiap.tech.challenge.adapter.gateway;

import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.adapter.repository.PaymentReaderRepository;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class PaymentReaderGatewayImpl implements PaymentReaderGateway {
    private final PaymentReaderRepository repository;

    @Override
    public Purchase readById(UUID id) {
        return PurchaseMapper.INSTANCE.toDomain(repository.readById(id.toString()));
    }
}
