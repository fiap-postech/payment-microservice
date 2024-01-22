package br.com.fiap.tech.challenge.launcher.configuration;

import br.com.fiap.tech.challenge.driven.consumer.config.CartConsumerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        CartConsumerConfiguration.class
})
public class MainConfiguration {
}
