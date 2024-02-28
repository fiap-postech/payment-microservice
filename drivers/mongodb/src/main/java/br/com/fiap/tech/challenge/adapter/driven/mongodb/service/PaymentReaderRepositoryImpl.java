package br.com.fiap.tech.challenge.adapter.driven.mongodb.service;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping.DBPaymentMapper;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.repository.PaymentRepository;
import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.adapter.repository.PaymentReaderRepository;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.fiap.tech.challenge.enterprise.error.ApplicationError.PURCHASE_NOT_FOUND_BY_UUID;

@Component
@RequiredArgsConstructor
public class PaymentReaderRepositoryImpl implements PaymentReaderRepository {

    private final DBPaymentMapper dbPaymentMapper;
    private final PaymentRepository repository;

    @Override
    public PaymentDTO readById(String id) {
        var paymentEntity = repository.findByPurchaseId(id).orElseThrow(() -> new ApplicationException(PURCHASE_NOT_FOUND_BY_UUID, id));
        return dbPaymentMapper.toDTO(paymentEntity);
    }
}
