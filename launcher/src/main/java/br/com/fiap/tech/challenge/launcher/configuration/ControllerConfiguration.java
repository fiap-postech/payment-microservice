package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.controller.payment.PaymentConfirmController;
import br.com.fiap.tech.challenge.adapter.controller.payment.PaymentController;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseControllerFactory;
import br.com.fiap.tech.challenge.adapter.presenter.PaymentPresenter;
import br.com.fiap.tech.challenge.adapter.producer.PaymentProducer;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentConfirmUseCase;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public PaymentController createPurchaseController(PaymentUseCase useCase) {
        return PurchaseControllerFactory.createPurchaseController(useCase);
    }

    @Bean
    public PaymentConfirmController paymentConfirmController(PaymentConfirmUseCase useCase, PaymentPresenter presenter, PaymentProducer producer) {
        return PurchaseControllerFactory.paymentConfirmController(useCase, presenter, producer);
    }
}
