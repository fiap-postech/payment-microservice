package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.gateway.PaymentGatewayFactory;
import br.com.fiap.tech.challenge.adapter.repository.PaymentReaderRepository;
import br.com.fiap.tech.challenge.adapter.repository.PaymentWritterRepository;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public PaymentWriterGateway paymentWriterGateway(PaymentWritterRepository repository) {
        return PaymentGatewayFactory.paymentWriterGateway(repository);
    }


    @Bean
    public PaymentReaderGateway purchaseReaderGateway(PaymentReaderRepository repository) {
        return PaymentGatewayFactory.paymentReaderGateway(repository);
    }

}
