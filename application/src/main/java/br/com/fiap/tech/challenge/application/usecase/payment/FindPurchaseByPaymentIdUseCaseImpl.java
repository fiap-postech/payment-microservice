package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.PaymentGateway;
import br.com.fiap.tech.challenge.application.gateway.PaymentReaderGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
class FindPurchaseByPaymentIdUseCaseImpl implements FindPurchaseByPaymentIdUseCase {

    private final PaymentGateway paymentGateway;
    private final PaymentReaderGateway paymentReaderGateway;


    @Override
    public Purchase getPurchase(String paymentId) {
        var purchaseUUID = paymentGateway.getPurchaseUUID(paymentId).orElseThrow();
        return paymentReaderGateway.readById(UUID.fromString(purchaseUUID));
    }
}
