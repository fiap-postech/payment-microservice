package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.PaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.payment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public PurchaseUseCase createPurchaseUseCase(PaymentGateway paymentGateway, PaymentWriterGateway paymentWriterGateway) {
        return PurchaseUseCaseFactory.createPurchaseUseCase(paymentGateway, paymentWriterGateway);
    }

    @Bean
    public UpdatePurchaseStatusUseCase updatePurchaseUseCase(PaymentWriterGateway gateway) {
        return PurchaseUseCaseFactory.updatePurchaseUseCase(gateway);
    }

    @Bean
    public FindPurchaseByPaymentIdUseCase findPurchaseByPaymentIdUseCase(PaymentGateway paymentGateway, PaymentReaderGateway paymentReaderGateway) {
        return PurchaseUseCaseFactory.findPurchaseByPaymentIdUseCase(paymentGateway, paymentReaderGateway);
    }

    @Bean
    public PaymentConfirmUseCase paymentConfirmUseCase(FindPurchaseByPaymentIdUseCase findPurchaseUseCase, UpdatePurchaseStatusUseCase updatePurchaseStatusUseCase) {
        return PurchaseUseCaseFactory.paymentConfirmUseCase(findPurchaseUseCase, updatePurchaseStatusUseCase);
    }
}
