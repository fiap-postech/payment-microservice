package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;

public interface PurchaseController {

    PurchaseDTO create(CartDTO cartDTO);
}
