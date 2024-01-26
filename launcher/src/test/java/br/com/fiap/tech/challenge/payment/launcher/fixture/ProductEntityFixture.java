package br.com.fiap.tech.challenge.payment.launcher.fixture;


import br.com.fiap.tech.challenge.adapter.driven.mongodb.model.ProductEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.net.URL;

import static br.com.fiap.tech.challenge.enterprise.enums.ProductCategory.SANDWICH;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductEntityFixture {

    public static Model<ProductEntity> productEntityModel() {
        return Instancio.of(ProductEntity.class)
                .generate(field(ProductEntity::getUuid), gen -> gen.text().uuid())
                .generate(field(ProductEntity::getImage), gen -> gen.net().url().as(URL::toString))
                .set(field(ProductEntity::getCategory), SANDWICH)
                .toModel();
    }
}
