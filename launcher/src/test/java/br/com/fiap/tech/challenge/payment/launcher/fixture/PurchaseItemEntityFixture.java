package br.com.fiap.tech.challenge.payment.launcher.fixture;

import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.PurchaseItemEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.payment.launcher.fixture.Fixture.create;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.ProductEntityFixture.productEntityModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseItemEntityFixture {

    public static Model<PurchaseItemEntity> purchaseItemEntityModel() {
        return Instancio.of(PurchaseItemEntity.class)
                .set(field(PurchaseItemEntity::getProduct), create(productEntityModel()))
                .toModel();
    }
}

