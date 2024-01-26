package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.rest.resource.request.PaymentConfirmRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.payment.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.PaymentDataRequestFixture.paymentDataRequestModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentConfirmRequestFixture {

    public static Model<PaymentConfirmRequest> paymentConfirmRequestModel() {
        return Instancio.of(PaymentConfirmRequest.class)
                .set(field(PaymentConfirmRequest::getData), create(paymentDataRequestModel()))
                .toModel();
    }

}