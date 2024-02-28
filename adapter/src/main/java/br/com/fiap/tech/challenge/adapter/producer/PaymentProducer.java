package br.com.fiap.tech.challenge.adapter.producer;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;

public interface PaymentProducer {

    void createdEvent(PaymentDTO paymentDTO);

    void doneEvent(PaymentDTO purchaseDTO);
}
