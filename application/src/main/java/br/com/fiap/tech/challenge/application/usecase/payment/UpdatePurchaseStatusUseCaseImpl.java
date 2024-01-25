package br.com.fiap.tech.challenge.application.usecase.payment;

import br.com.fiap.tech.challenge.application.gateway.PaymentWriterGateway;
import br.com.fiap.tech.challenge.enterprise.entity.Purchase;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UpdatePurchaseStatusUseCaseImpl implements UpdatePurchaseStatusUseCase {

    private final PaymentWriterGateway gateway;

    @Override
    public Purchase update(Purchase purchase, PurchaseStatus status) {
        var updatedPurchase = switch (status) {
            case WAITING_PAID -> purchase;
            case PAID -> purchase.paid();
            case MAKING -> purchase.making();
            case MADE -> purchase.made();
            case DELIVERED -> purchase.delivered();
            case FINISHED -> purchase.finished();
        };

        return gateway.write(updatedPurchase);
    }
}
