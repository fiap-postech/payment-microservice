package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.application.gateway.MarketPaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.application.usecase.payment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public PaymentUseCase createPurchaseUseCase(MarketPaymentGateway marketPaymentGateway, PaymentWriterGateway paymentWriterGateway) {
        return PurchaseUseCaseFactory.createPurchaseUseCase(marketPaymentGateway, paymentWriterGateway);
    }

    @Bean
    public UpdatePaymentStatusUseCase updatePurchaseUseCase(PaymentWriterGateway gateway) {
        return PurchaseUseCaseFactory.updatePurchaseUseCase(gateway);
    }

    @Bean
    public FindPaymentByMarketPaymentIdUseCase findPurchaseByPaymentIdUseCase(PaymentReaderGateway paymentReaderGateway, MarketPaymentGateway marketPaymentGateway) {
        return PurchaseUseCaseFactory.findPurchaseByPaymentIdUseCase(paymentReaderGateway, marketPaymentGateway);
    }

    @Bean
    public PaymentConfirmUseCase paymentConfirmUseCase(FindPaymentByMarketPaymentIdUseCase findPurchaseUseCase, UpdatePaymentStatusUseCase updatePaymentStatusUseCase) {
        return PurchaseUseCaseFactory.paymentConfirmUseCase(findPurchaseUseCase, updatePaymentStatusUseCase);
    }
}
