package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.config.PaymentRepositoryConfiguration;
import br.com.fiap.tech.challenge.adapter.driven.payment.gateway.config.PaymentGatewayConfiguration;
import br.com.fiap.tech.challenge.driven.consumer.config.CartConsumerConfiguration;
import br.com.fiap.tech.challenge.driven.purchase.PurchaseProducerConfiguration;
import br.com.fiap.tech.challenge.rest.config.RestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RestConfiguration.class,
        ControllerConfiguration.class,
        CartConsumerConfiguration.class,
        PurchaseProducerConfiguration.class,
        UseCaseConfiguration.class,
        PaymentGatewayConfiguration.class,
        PaymentRepositoryConfiguration.class,
        PresenterConfiguration.class,
        GatewayConfiguration.class
})
public class MainConfiguration {
}
