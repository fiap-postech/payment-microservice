package br.com.fiap.tech.challenge.payment.launcher.config;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.config.PaymentRepositoryConfiguration;
import br.com.fiap.tech.challenge.adapter.driven.payment.gateway.config.PaymentGatewayConfiguration;
import br.com.fiap.tech.challenge.driven.consumer.config.CartConsumerConfiguration;
import br.com.fiap.tech.challenge.driven.purchase.PurchaseProducerConfiguration;
import br.com.fiap.tech.challenge.launcher.configuration.*;
import br.com.fiap.tech.challenge.rest.config.RestConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.tech.challenge")
@EntityScan(basePackages = "br.com.fiap.tech.challenge")
@Import(
        {
                RestConfiguration.class,
                ControllerConfiguration.class,
                CartConsumerConfiguration.class,
                PurchaseProducerConfiguration.class,
                UseCaseConfiguration.class,
                PaymentGatewayConfiguration.class,
                PaymentRepositoryConfiguration.class,
                PresenterConfiguration.class,
                GatewayConfiguration.class
        }
)
public class TestConfiguration {
}
