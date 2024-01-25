package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;

public interface PaymentReaderRepository {

    PurchaseDTO readById(String id);
}
