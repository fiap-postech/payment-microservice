package br.com.fiap.tech.challenge.driven.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.consumer.PurchaseListener;
import br.com.fiap.tech.challenge.adapter.controller.payment.PaymentController;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.producer.PaymentProducer;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PurchaseListenerImpl implements PurchaseListener {

    private final PaymentController paymentController;
    private final PaymentProducer paymentProducer;

    @Override
    @SqsListener("${aws.sqs.purchase-create.name}")
    public void close(Message<PurchaseDTO> message) {
        var paymentDTO = paymentController.create(message.getPayload());
        paymentProducer.createdEvent(paymentDTO);
    }
}
