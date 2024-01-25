package br.com.fiap.tech.challenge.adapter.consumer;

import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import org.springframework.messaging.Message;


public interface CartListener {

    void close(Message<CartDTO> dto);
}
