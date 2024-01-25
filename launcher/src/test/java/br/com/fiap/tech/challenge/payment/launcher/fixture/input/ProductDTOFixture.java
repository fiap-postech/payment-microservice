package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.ComboDTO;
import br.com.fiap.tech.challenge.adapter.dto.ProductDTO;
import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.math.BigDecimal;
import java.net.URL;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDTOFixture {

    public static Model<ProductDTO> beverageDTO() {
        return Instancio.of(ProductDTO.class)
                .generate(field(ProductDTO::getId), gen -> gen.text().uuid())
                .generate(field(ProductDTO::getImage), gen -> gen.net().url().as(URL::toString))
                .set(field(ProductDTO::getCategory), ProductCategory.BEVERAGE)
                .set(field(ProductDTO::getName), "Bebida")
                .set(field(ProductDTO::getPrice), BigDecimal.valueOf(5.00))
                .set(field(ProductDTO::getFullPrice), BigDecimal.valueOf(5.00))
                .set(field(ProductDTO::getDiscount), BigDecimal.ZERO)
                .toModel();
    }

    public static Model<ProductDTO> sideDishDTO() {
        return Instancio.of(ProductDTO.class)
                .generate(field(ProductDTO::getId), gen -> gen.text().uuid())
                .generate(field(ProductDTO::getImage), gen -> gen.net().url().as(URL::toString))
                .set(field(ProductDTO::getCategory), ProductCategory.SIDE_DISH)
                .set(field(ProductDTO::getName), "Acompanhamento")
                .set(field(ProductDTO::getPrice), BigDecimal.valueOf(3.00))
                .set(field(ProductDTO::getFullPrice), BigDecimal.valueOf(3.00))
                .set(field(ProductDTO::getDiscount), BigDecimal.ZERO)
                .toModel();
    }

    public static Model<ProductDTO> sandwichDTO() {
        return Instancio.of(ProductDTO.class)
                .generate(field(ProductDTO::getId), gen -> gen.text().uuid())
                .generate(field(ProductDTO::getImage), gen -> gen.net().url().as(URL::toString))
                .set(field(ProductDTO::getCategory), ProductCategory.SANDWICH)
                .set(field(ProductDTO::getName), "Lanche")
                .set(field(ProductDTO::getPrice), BigDecimal.valueOf(17.00))
                .set(field(ProductDTO::getFullPrice), BigDecimal.valueOf(17.00))
                .set(field(ProductDTO::getDiscount), BigDecimal.ZERO)
                .toModel();
    }

    public static Model<ComboDTO> comboDTO() {
        return Instancio.of(ComboDTO.class)
                .generate(field(ComboDTO::getId), gen -> gen.text().uuid())
                .generate(field(ProductDTO::getImage), gen -> gen.net().url().as(URL::toString))
                .set(field(ProductDTO::getCategory), ProductCategory.COMBO)
                .set(field(ComboDTO::getName), "Combo")
                .set(field(ComboDTO::getPrice), BigDecimal.valueOf(20.00))
                .set(field(ComboDTO::getFullPrice), BigDecimal.valueOf(25.00))
                .set(field(ComboDTO::getDiscount), BigDecimal.valueOf(5.00))
                .set(field(ComboDTO::getBeverage), Instancio.create(beverageDTO()))
                .set(field(ComboDTO::getSideDish), Instancio.create(sideDishDTO()))
                .set(field(ComboDTO::getSandwich), Instancio.create(sandwichDTO()))
                .toModel();
    }

}
