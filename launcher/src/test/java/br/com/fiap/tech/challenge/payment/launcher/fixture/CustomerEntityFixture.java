package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.CustomerEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerEntityFixture {

    public static Model<CustomerEntity> customerEntityModel() {
        return Instancio.of(CustomerEntity.class)
                .generate(field(CustomerEntity::getUuid), gen -> gen.text().uuid())
                .set(field(CustomerEntity::getEmail), "consumidor@digio.com.br")
                .set(field(CustomerEntity::getDocument), "00000000000")
                .toModel();
    }
}
