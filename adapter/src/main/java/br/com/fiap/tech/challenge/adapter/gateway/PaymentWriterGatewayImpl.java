package br.com.fiap.tech.challenge.adapter.gateway;

import br.com.fiap.tech.challenge.adapter.mapping.PaymentMapper;
import br.com.fiap.tech.challenge.adapter.repository.PaymentWritterRepository;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentWriterGatewayImpl implements PaymentWriterGateway {

    private final PaymentWritterRepository repository;

    @Override
    public Payment write(Payment payment) {
        var mapper = PaymentMapper.INSTANCE;

        return mapper.toDomain(repository.write(mapper.toDTO(payment)));
    }
}
