package br.com.fiap.tech.challenge.adapter.driven.mongodb.service;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping.DBPaymentMapper;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping.DBPurchaseMapper;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.repository.PaymentRepository;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PaymentWritterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentWritterRepositoryImpl implements PaymentWritterRepository {

    private final DBPaymentMapper dbPaymentMapper;
    private final DBPurchaseMapper dbPurchaseMapper;
    private final PaymentRepository repository;

    @Override
    public PurchaseDTO write(PurchaseDTO dto) {

        var paymentEntity = dbPaymentMapper.toEntity(dto.getPayment());
        var purchaseEntity = dbPurchaseMapper.toEntity(dto);

        paymentEntity.setPurchase(purchaseEntity);

        repository.save(paymentEntity);

        PurchaseDTO response = dbPurchaseMapper.toDTO(purchaseEntity);
        response.setPayment(dto.getPayment());

        return response;
    }
}
