package br.com.fiap.tech.challenge.driven.consumer.config;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.tech.challenge.driven.consumer")
public class CartConsumerConfiguration {

    @Bean
    public SqsTemplate sqsTemplateManualContainerInstantiation(SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder().sqsAsyncClient(sqsAsyncClient).build();
    }
}