package br.com.fiap.tech.challenge.driven.purchase;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.adapter.producer.PaymentProducer;
import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class PaymentProducerImpl implements PaymentProducer {

    private static final String CREATED_PAYMENT_SNS_NAME_KEY = "aws.sns.created-payment.name";
    private static final String DONE_PAYMENT_SNS_NAME_KEY = "aws.sns.done-payment.name";

    private final SnsTemplate snsTemplate;
    private final Environment env;

    @Override
    public void createdEvent(PaymentDTO paymentDTO) {
        snsTemplate.convertAndSend(requireNonNull(env.getProperty(CREATED_PAYMENT_SNS_NAME_KEY)), paymentDTO);
    }

    @Override
    public void doneEvent(PaymentDTO paymentDTO) {
        snsTemplate.convertAndSend(requireNonNull(env.getProperty(DONE_PAYMENT_SNS_NAME_KEY)), paymentDTO);
    }
}