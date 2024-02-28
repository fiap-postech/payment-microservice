package br.com.fiap.tech.challenge.rest.resource.doc;

import br.com.fiap.tech.challenge.rest.resource.request.PaymentConfirmRequest;
import br.com.fiap.tech.challenge.rest.resource.response.PaymentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Pagamento", description = "API responsável pelo gerenciamento do Pagamento")
public interface PaymentResourceDoc {

    @Operation(
            summary = "Realiza a confirmação do pagamento",
            description = "Endpoint para webHook do gateway de pagamento realizar a confirmação do pagamento.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK - Retorna a visão do pedido com um objeto de pagamento atualizado.", useReturnTypeSchema = true)
            }
    )
    PaymentResponse confirmPaymentForPurchase(@RequestBody PaymentConfirmRequest confirmRequest);
}
