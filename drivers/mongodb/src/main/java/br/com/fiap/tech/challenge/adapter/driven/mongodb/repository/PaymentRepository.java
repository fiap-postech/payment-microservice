package br.com.fiap.tech.challenge.adapter.driven.mongodb.repository;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {

    Optional<PaymentEntity> findByPurchaseId(String uuid);

    Optional<PaymentEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
