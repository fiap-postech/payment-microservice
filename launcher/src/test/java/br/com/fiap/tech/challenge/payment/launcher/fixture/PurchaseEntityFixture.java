package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PurchaseEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.List;

import static br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus.PAID;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.CustomerEntityFixture.customerEntityModel;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.PurchaseItemEntityFixture.purchaseItemEntityModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseEntityFixture {
    public static Model<PurchaseEntity> purchaseEntityModel() {
        return Instancio.of(PurchaseEntity.class)
                .set(field(PurchaseEntity::getUuid), "6efa43ba-6166-42dd-b46a-c5698922465a")
                .set(field(PurchaseEntity::getCartUUID), "ff53696e-fdd5-4bf0-8edc-b89a78922c14")
                .set(field(PurchaseEntity::getStatus), PAID)
                .set(field(PurchaseEntity::getCustomer), create(customerEntityModel()))
                .set(field(PurchaseEntity::getItems), List.of(create(purchaseItemEntityModel())))
                .toModel();
    }
}
