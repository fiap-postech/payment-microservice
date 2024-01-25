package br.com.fiap.tech.challenge.driven.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.consumer.CartListener;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseController;
import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.adapter.producer.PurchaseProducer;
import br.com.fiap.tech.challenge.driven.consumer.util.JsonUtil;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartListenerImpl implements CartListener {

    private final PurchaseController purchaseController;
    private final PurchaseProducer purchaseProducer;

    @Override
    @SqsListener("${aws.sqs.close-cart.name}")
    public void close(String message) {

        var dto = JsonUtil.fromJsonString(message, CartDTO.class);
        var purchaseDTO = purchaseController.create(dto);

        purchaseProducer.createdEvent(purchaseDTO);
    }
}
