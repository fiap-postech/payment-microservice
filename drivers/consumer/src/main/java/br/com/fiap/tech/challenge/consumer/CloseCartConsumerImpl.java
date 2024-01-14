package br.com.fiap.tech.challenge.consumer;
import br.com.fiap.tech.challenge.adapter.consumer.CloseCartConsumer;
import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.adapter.controller.payment.PurchaseController;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CloseCartConsumerImpl implements CloseCartConsumer{

    private final PurchaseController purchaseController;

    @Override
    @SqsListener("${aws.sqs.close-cart.name}")
    public void close(CartDTO dto) {
        var purchaseDTO = purchaseController.create(dto);

        System.out.println(purchaseDTO);

        // registra o purchase para atualizacoes no MongoDb
        // criar get para buscar um pedido pelo UUID do carrinho?
        // criar o endpoint para confirm - payment (webhook do Mercado Pago)
        // ao receber o webhook do Mercado Pago fazer o producer para servico de pedido (checkout)
    }
}
