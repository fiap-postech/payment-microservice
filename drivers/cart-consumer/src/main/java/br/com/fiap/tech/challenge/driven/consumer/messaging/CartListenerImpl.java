package br.com.fiap.tech.challenge.driven.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.consumer.CartListener;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseController;
import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.driven.consumer.util.JsonUtil;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartListenerImpl implements CartListener {

    private final PurchaseController purchaseController;

    @Override
    @SqsListener("${aws.sqs.close-cart.name}")
    public void close(String message) {

        var dto = JsonUtil.fromJsonString(message, CartDTO.class);
        var purchaseDTO = purchaseController.create(dto);

        System.out.println(purchaseDTO);

        // registra o purchase para atualizacoes no MongoDb
        // criar get para buscar um pedido pelo UUID do carrinho?



        // criar o endpoint para confirm - payment (webhook do Mercado Pago)
        // ao receber o webhook do Mercado Pago fazer o producer para servico de pedido (checkout)
    }
}
