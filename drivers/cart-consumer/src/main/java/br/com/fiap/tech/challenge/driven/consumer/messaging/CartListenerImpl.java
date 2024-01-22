package br.com.fiap.tech.challenge.driven.consumer.messaging;

import br.com.fiap.tech.challenge.adapter.consumer.CartListener;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseController;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartListenerImpl implements CartListener {

    private final PurchaseController purchaseController;

    @Override
    @SqsListener(queueNames = "${aws.sqs.close-cart.name}")
    public void close(String dto) {
        System.out.println(dto);
//        var purchaseDTO = purchaseController.create(dto);
//
//        System.out.println(purchaseDTO);

        // registra o purchase para atualizacoes no MongoDb
        // criar get para buscar um pedido pelo UUID do carrinho?
        // criar o endpoint para confirm - payment (webhook do Mercado Pago)
        // ao receber o webhook do Mercado Pago fazer o producer para servico de pedido (checkout)
    }
}
