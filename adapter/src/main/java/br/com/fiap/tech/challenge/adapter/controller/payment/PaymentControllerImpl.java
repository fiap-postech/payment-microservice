package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.mapping.PaymentMapper;
import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.application.usecase.payment.PaymentUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentControllerImpl implements PaymentController {

    private final PaymentUseCase paymentUseCase;

    @Override
    public PaymentDTO create(PurchaseDTO purchaseDTO) {
        var purchase = PurchaseMapper.INSTANCE.toDomain(purchaseDTO);
        var payment = paymentUseCase.create(purchase);
        return PaymentMapper.INSTANCE.toDTO(payment);
    }
}
