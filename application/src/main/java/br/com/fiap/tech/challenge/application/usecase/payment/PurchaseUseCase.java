package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.enterprise.entity.Cart;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

import java.util.Optional;

public interface PurchaseUseCase {

    Purchase create(Cart cart);
}
