package br.com.fiap.tech.challenge.adapter.driven.mongodb.repository;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {

    @Query(value = "{'purchase.uuid': ?0}", fields = "{ 'purchase.uuid' : 0 }")
    Optional<PaymentEntity> findByPurchaseUUID(String uuid);

    Optional<PaymentEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
