package br.com.fiap.tech.challenge.driven.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.producer.PurchaseProducer;
import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class PurchaseProducerImpl implements PurchaseProducer {

    private static final String CREATED_PAYMENT_SNS_NAME_KEY = "aws.sns.created-payment.name";
    private static final String DONE_PAYMENT_SNS_NAME_KEY = "aws.sns.done-payment.name";

    private final SnsTemplate snsTemplate;
    private final Environment env;

    @Override
    public void createdEvent(PurchaseDTO purchaseDTO) {
        snsTemplate.send(requireNonNull(env.getProperty(CREATED_PAYMENT_SNS_NAME_KEY)), MessageBuilder.withPayload(purchaseDTO).build());
    }

    @Override
    public void doneEvent(PurchaseDTO purchaseDTO) {
        snsTemplate.send(requireNonNull(env.getProperty(DONE_PAYMENT_SNS_NAME_KEY)), MessageBuilder.withPayload(purchaseDTO).build());
    }
}