package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.rest.resource.response.CustomerResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.UUID;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerResponseFixture {

    public static Model<CustomerResponse> consumerCustomerResponseModel() {
        return Instancio.of(CustomerResponse.class)
                .set(field(CustomerResponse::getId), UUID.randomUUID().toString())
                .set(field(CustomerResponse::getName), "Consumidor")
                .set(field(CustomerResponse::getDocument), "00000000000")
                .set(field(CustomerResponse::getEmail), "consumidor@digio.com.br")
                .toModel();
    }

}
