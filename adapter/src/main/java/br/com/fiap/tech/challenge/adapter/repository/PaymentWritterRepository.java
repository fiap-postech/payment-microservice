package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;

public interface PaymentWritterRepository {
    PurchaseDTO write (PurchaseDTO dto);
}
