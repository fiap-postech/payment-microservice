package br.com.fiap.tech.challenge.consumer;
import br.com.fiap.tech.challenge.adapter.consumer.CloseCartConsumer;
import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;


public class CloseCartConsumerImpl implements CloseCartConsumer{

    @Override
    @SqsListener("${aws.sqs.close-cart.name}")
    public void close(CartDTO dto) {

    }
}
