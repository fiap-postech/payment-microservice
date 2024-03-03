package br.com.fiap.tech.challenge.adapter.repository;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;

public interface PaymentReaderRepository {

    PaymentDTO readById(String id);
}
