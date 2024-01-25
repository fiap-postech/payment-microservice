package br.com.fiap.tech.challenge.adapter.driven.mongodb.repository;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {

    @Query(value = "{'purchase.uuid': ?0}", fields = "{ 'purchase.uuid' : 0 }")
    Optional<PaymentEntity> findByPurchaseUUID(String uuid);

    @Query(value = "{'purchase.cartUUID': ?0}", fields = "{ 'purchase.cartUUID' : 0 }")
    Optional<PaymentEntity> findByCartUUID(String cartUUID);

    Optional<PaymentEntity> findByUuid(String uuid);

    void deleteByUuid(String uuid);
}
