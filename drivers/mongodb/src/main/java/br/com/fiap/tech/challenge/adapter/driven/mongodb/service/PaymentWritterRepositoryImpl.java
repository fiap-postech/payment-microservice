package br.com.fiap.tech.challenge.adapter.driven.mongodb.service;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.mapping.DBPaymentMapper;
import br.com.fiap.tech.challenge.adapter.driven.mongodb.repository.PaymentRepository;
import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.adapter.repository.PaymentWritterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentWritterRepositoryImpl implements PaymentWritterRepository {

    private final DBPaymentMapper dbPaymentMapper;
    private final PaymentRepository repository;

    @Override
    public PaymentDTO write(PaymentDTO dto) {
        var paymentEntity = dbPaymentMapper.toEntity(dto);

        var paymentEntityOpt = repository.findByUuid(paymentEntity.getUuid());

        if(paymentEntityOpt.isPresent()){
            repository.deleteByUuid(paymentEntity.getUuid());
        }

        return dbPaymentMapper.toDTO(repository.save(paymentEntity));
    }
}
