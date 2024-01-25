package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.adapter.mapping.PurchaseMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

class PurchasePresenterImpl implements PurchasePresenter{
    @Override
    public PurchaseDTO present(Purchase purchase) {
        var purchaseDTO = PurchaseMapper.INSTANCE.toDTO(purchase);
        purchaseDTO.setId(null);
        purchaseDTO.getPayment().setUrlPayment(null);
        return purchaseDTO;
    }

}
