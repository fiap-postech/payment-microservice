package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;

public interface PaymentUseCase {

    Payment create(Purchase purchase);
}
