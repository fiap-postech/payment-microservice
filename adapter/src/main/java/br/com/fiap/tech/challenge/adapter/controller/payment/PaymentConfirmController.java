package br.com.fiap.tech.challenge.adapter.controller.payment;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.application.dto.PaymentConfirmDTO;

public interface PaymentConfirmController {
    PaymentDTO confirm(PaymentConfirmDTO dto);
}
