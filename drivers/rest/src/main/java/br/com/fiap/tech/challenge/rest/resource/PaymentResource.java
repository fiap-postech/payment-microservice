package br.com.fiap.tech.challenge.rest.resource;

import br.com.fiap.tech.challenge.adapter.controller.payment.PaymentConfirmController;
import br.com.fiap.tech.challenge.rest.mapping.PaymentConfirmMapper;
import br.com.fiap.tech.challenge.rest.mapping.PurchaseResponseMapper;
import br.com.fiap.tech.challenge.rest.resource.doc.PaymentResourceDoc;
import br.com.fiap.tech.challenge.rest.resource.request.PaymentConfirmRequest;
import br.com.fiap.tech.challenge.rest.resource.response.PurchseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentResource implements PaymentResourceDoc {

    private final PaymentConfirmMapper paymentConfirmMapper;
    private final PurchaseResponseMapper purchaseResponseMapper;
    private final PaymentConfirmController paymentConfirmController;

    @PostMapping("/confirm")
    public PurchseResponse confirmPaymentForPurchase(@RequestBody PaymentConfirmRequest confirmRequest) {
        return purchaseResponseMapper.toResponse(
                paymentConfirmController.confirm(paymentConfirmMapper.toDTO(confirmRequest))
        );
    }
}