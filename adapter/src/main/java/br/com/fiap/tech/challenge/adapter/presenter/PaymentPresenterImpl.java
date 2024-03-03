package br.com.fiap.tech.challenge.adapter.presenter;

import br.com.fiap.tech.challenge.adapter.dto.PaymentDTO;
import br.com.fiap.tech.challenge.adapter.mapping.PaymentMapper;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;

class PaymentPresenterImpl implements PaymentPresenter {
    @Override
    public PaymentDTO present(Payment payment) {
        return PaymentMapper.INSTANCE.toDTO(payment);
    }

}
