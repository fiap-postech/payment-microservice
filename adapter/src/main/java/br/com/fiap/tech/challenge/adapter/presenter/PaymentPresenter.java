package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;

public interface PaymentPresenter {

    PaymentDTO present(Payment payment);

}
