package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.config.PaymentRepositoryConfiguration;
import br.com.fiap.tech.challenge.adapter.driven.payment.gateway.config.PaymentGatewayConfiguration;
import br.com.fiap.tech.challenge.driven.consumer.config.CartConsumerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ControllerConfiguration.class,
        CartConsumerConfiguration.class,
        UseCaseConfiguration.class,
        PaymentGatewayConfiguration.class,
        PaymentRepositoryConfiguration.class,
        GatewayConfiguration.class
})
public class MainConfiguration {
}
