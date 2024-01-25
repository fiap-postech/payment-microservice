package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;

public interface UpdatePurchaseStatusUseCase {

    Purchase update(Purchase purchase, PurchaseStatus status);
}
