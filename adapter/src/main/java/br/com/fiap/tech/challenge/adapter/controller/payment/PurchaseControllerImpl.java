package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.mapping.CartMapper;
import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.application.usecase.payment.PurchaseUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PurchaseControllerImpl implements PurchaseController {

    private final PurchaseUseCase purchaseUseCase;

    @Override
    public PurchaseDTO create(CartDTO cartDTO) {
        var purchase = purchaseUseCase.create(CartMapper.INSTANCE.toDomain(cartDTO));
        return PurchaseMapper.INSTANCE.toDTO(purchase);
    }
}
