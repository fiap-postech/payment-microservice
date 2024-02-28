package br.com.fiap.tech.challenge.adapter.consumer;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import org.springframework.messaging.Message;


public interface PurchaseListener {

    void close(Message<PurchaseDTO> dto);
}
