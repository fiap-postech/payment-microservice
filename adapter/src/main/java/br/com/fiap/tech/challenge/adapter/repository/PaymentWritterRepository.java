package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;

public interface PaymentWritterRepository {
    PaymentDTO write (PaymentDTO dto);
}
