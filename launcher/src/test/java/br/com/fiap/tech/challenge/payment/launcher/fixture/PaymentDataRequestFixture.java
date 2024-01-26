package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.rest.resource.request.PaymentDataRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentDataRequestFixture {

    public static final String PAYMENT_GATEWAY_ID = "1320878341";

    public static Model<PaymentDataRequest> paymentDataRequestModel() {
        return Instancio.of(PaymentDataRequest.class)
                .set(field(PaymentDataRequest::getId), PAYMENT_GATEWAY_ID)
                .toModel();
    }

}
