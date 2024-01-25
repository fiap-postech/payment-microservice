package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.controller.payment.PaymentConfirmController;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseController;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseControllerFactory;
import br.com.fiap.tech.challenge.adapter.presenter.PurchasePresenter;
import br.com.fiap.tech.challenge.adapter.producer.PurchaseProducer;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentConfirmUseCase;
import br.com.fiap.tech.challenge.application.usecase.payment.PurchaseUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public PurchaseController createPurchaseController(PurchaseUseCase useCase) {
        return PurchaseControllerFactory.createPurchaseController(useCase);
    }

    @Bean
    public PaymentConfirmController paymentConfirmController(PaymentConfirmUseCase useCase, PurchasePresenter presenter, PurchaseProducer producer) {
        return PurchaseControllerFactory.paymentConfirmController(useCase, presenter, producer);
    }
}
