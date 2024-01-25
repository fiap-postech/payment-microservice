package br.com.fiap.tech.challenge.adapter.gateway;

import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.adapter.repository.PaymentWritterRepository;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentWriterGatewayImpl implements PaymentWriterGateway {

    private final PaymentWritterRepository repository;

    @Override
    public Purchase write(Purchase purchase) {
        var mapper = PurchaseMapper.INSTANCE;

        return mapper.toDomain(repository.write(mapper.toDTO(purchase)));
    }
}
