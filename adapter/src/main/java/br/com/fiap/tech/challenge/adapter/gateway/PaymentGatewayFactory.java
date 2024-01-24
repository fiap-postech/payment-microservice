package br.com.fiap.tech.challenge.adapter.gateway;

import br.com.fiap.tech.challenge.adapter.repository.PaymentWritterRepository;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentGatewayFactory {

    public static PaymentWriterGateway paymentWriterGateway(PaymentWritterRepository repository) {
        return new PaymentWriterGatewayImpl(repository);
    }
}
