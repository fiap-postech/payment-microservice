package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.math.BigDecimal;

import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.ProductDTOFixture.*;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseItemDTOFixture {

    public static Model<PurchaseItemDTO> singleBeverageItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getProduct), Instancio.create(beverageDTO()))
                .set(field(PurchaseItemDTO::getPrice), BigDecimal.valueOf(5.00))
                .set(field(PurchaseItemDTO::getFullPrice), BigDecimal.valueOf(5.00))
                .set(field(PurchaseItemDTO::getDiscount), BigDecimal.ZERO)
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .toModel();
    }

    public static Model<PurchaseItemDTO> singleSideDishItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getProduct), Instancio.create(sideDishDTO()))
                .set(field(PurchaseItemDTO::getPrice), BigDecimal.valueOf(3.00))
                .set(field(PurchaseItemDTO::getFullPrice), BigDecimal.valueOf(3.00))
                .set(field(PurchaseItemDTO::getDiscount), BigDecimal.ZERO)
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .toModel();
    }

    public static Model<PurchaseItemDTO> singleSandwichItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getProduct), Instancio.create(sandwichDTO()))
                .set(field(PurchaseItemDTO::getPrice), BigDecimal.valueOf(17.00))
                .set(field(PurchaseItemDTO::getFullPrice), BigDecimal.valueOf(17.00))
                .set(field(PurchaseItemDTO::getDiscount), BigDecimal.ZERO)
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .toModel();
    }

    public static Model<PurchaseItemDTO> singleComboItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getProduct), Instancio.create(comboDTO()))
                .set(field(PurchaseItemDTO::getPrice), BigDecimal.valueOf(20.00))
                .set(field(PurchaseItemDTO::getFullPrice), BigDecimal.valueOf(25.00))
                .set(field(PurchaseItemDTO::getDiscount), BigDecimal.valueOf(5.00))
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .toModel();
    }
}
