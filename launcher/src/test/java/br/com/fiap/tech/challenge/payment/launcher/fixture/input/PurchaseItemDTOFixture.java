package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseItemDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseItemDTOFixture {


    public static Model<PurchaseItemDTO> singleBeverageItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getTitle), "BeverageItem")
                .set(field(PurchaseItemDTO::getDescription), "BeverageDescription")
                .set(field(PurchaseItemDTO::getCategoryId), ProductCategory.BEVERAGE)
                .set(field(PurchaseItemDTO::getCurrencyId), "BRL")
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .set(field(PurchaseItemDTO::getUnitPrice), "23.50")
                .toModel();
    }

    public static Model<PurchaseItemDTO> singleSideDishItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getTitle), "SideDish")
                .set(field(PurchaseItemDTO::getDescription), "SideDishDescription")
                .set(field(PurchaseItemDTO::getCategoryId), ProductCategory.SIDE_DISH)
                .set(field(PurchaseItemDTO::getCurrencyId), "BRL")
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .set(field(PurchaseItemDTO::getUnitPrice), "7.50")
                .toModel();
    }

    public static Model<PurchaseItemDTO> singleSandwichItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getTitle), "SandwichItem")
                .set(field(PurchaseItemDTO::getDescription), "SandwichDescription")
                .set(field(PurchaseItemDTO::getCategoryId), ProductCategory.SANDWICH)
                .set(field(PurchaseItemDTO::getCurrencyId), "BRL")
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .set(field(PurchaseItemDTO::getUnitPrice), "6.00")
                .toModel();
    }

    public static Model<PurchaseItemDTO> singleComboItemDTO() {
        return Instancio.of(PurchaseItemDTO.class)
                .set(field(PurchaseItemDTO::getTitle), "ComboItem")
                .set(field(PurchaseItemDTO::getDescription), "ComboDescription")
                .set(field(PurchaseItemDTO::getCategoryId), ProductCategory.COMBO)
                .set(field(PurchaseItemDTO::getCurrencyId), "BRL")
                .set(field(PurchaseItemDTO::getQuantity), 1)
                .set(field(PurchaseItemDTO::getUnitPrice), "18.50")
                .toModel();
    }
}
