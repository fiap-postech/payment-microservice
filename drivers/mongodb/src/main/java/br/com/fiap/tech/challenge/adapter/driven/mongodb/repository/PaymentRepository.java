package br.com.fiap.tech.challenge.adapter.driven.mongodb.repository;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
}
