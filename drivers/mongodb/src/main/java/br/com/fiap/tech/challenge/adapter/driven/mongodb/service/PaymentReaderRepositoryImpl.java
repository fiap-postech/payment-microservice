package br.com.fiap.tech.challenge.adapter.driven.mongodb.service;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping.DBPaymentMapper;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping.DBPurchaseMapper;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.repository.PaymentRepository;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.repository.PaymentReaderRepository;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_NOT_FOUND_BY_UUID;

@Component
@RequiredArgsConstructor
public class PaymentReaderRepositoryImpl implements PaymentReaderRepository {

    private final DBPaymentMapper dbPaymentMapper;
    private final DBPurchaseMapper dbPurchaseMapper;
    private final PaymentRepository repository;

    @Override
    public PurchaseDTO readById(String id) {
        var paymentEntity = repository.findByPurchaseUUID(id).orElseThrow(() -> new ApplicationException(PURCHASE_NOT_FOUND_BY_UUID, id));

        var paymentDTO = dbPaymentMapper.toDTO(paymentEntity);
        var purchaseDTO = dbPurchaseMapper.toDTO(paymentEntity.getPurchase());

        purchaseDTO.setPayment(paymentDTO);
        purchaseDTO.setId(id);

        return purchaseDTO;
    }
}
