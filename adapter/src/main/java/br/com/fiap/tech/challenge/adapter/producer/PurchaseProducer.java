package br.com.fiap.tech.challenge.adapter.producer;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;

public interface PurchaseProducer {

    void createdEvent(PurchaseDTO purchaseDTO);

    void doneEvent(PurchaseDTO purchaseDTO);
}
