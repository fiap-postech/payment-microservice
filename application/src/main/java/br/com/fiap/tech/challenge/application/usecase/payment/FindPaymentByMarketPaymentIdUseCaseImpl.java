package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.MarketPaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Payment;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class FindPaymentByMarketPaymentIdUseCaseImpl implements FindPaymentByMarketPaymentIdUseCase {

    private final PaymentReaderGateway paymentReaderGateway;
    private final MarketPaymentGateway marketPaymentGateway;


    @Override
    public Payment getPayment(String marketPaymentId) {
        var marketPaymentDTO = marketPaymentGateway.getPurchaseUUID(marketPaymentId).orElseThrow();
        var payment = paymentReaderGateway.readById(UUID.fromString(marketPaymentDTO.getPurchaseUUID()));
        return marketPaymentDTO.getStatusMarketPayment().equals("approved")? payment.paid() : payment.error();
    }
}
