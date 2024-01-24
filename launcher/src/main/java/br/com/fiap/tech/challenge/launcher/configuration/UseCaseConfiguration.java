package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.PaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.payment.PurchaseUseCase;
import br.com.fiap.tech.challenge.application.usecase.payment.PurchaseUseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public PurchaseUseCase createPurchaseUseCase(PaymentGateway paymentGateway, PaymentWriterGateway paymentWriterGateway) {
        return PurchaseUseCaseFactory.createPurchaseUseCase(paymentGateway, paymentWriterGateway);
    }
}
