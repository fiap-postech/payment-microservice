package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.CartItemDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.ProductDTOFixture.*;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartItemDTOFixture {

    public static Model<CartItemDTO> cartItemBeverageDTO() {
        return Instancio.of(CartItemDTO.class)
                .set(field(CartItemDTO::getProduct), Instancio.create(beverageDTO()))
                .toModel();
    }

    public static Model<CartItemDTO> cartItemSideDishDTO() {
        return Instancio.of(CartItemDTO.class)
                .set(field(CartItemDTO::getProduct), Instancio.create(sideDishDTO()))
                .toModel();
    }

    public static Model<CartItemDTO> cartItemSandwichDTO() {
        return Instancio.of(CartItemDTO.class)
                .set(field(CartItemDTO::getProduct), Instancio.create(sandwichDTO()))
                .toModel();
    }

    public static Model<CartItemDTO> cartItemComboDTO() {
        return Instancio.of(CartItemDTO.class)
                .set(field(CartItemDTO::getProduct), Instancio.create(comboDTO()))
                .toModel();
    }

}
