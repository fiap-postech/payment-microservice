package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.dto.PaymentConfirmDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;

public interface PaymentConfirmUseCase {

    Payment confirm(PaymentConfirmDTO dto);

}
