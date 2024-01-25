package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.CartDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.List;

import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.CartItemDTOFixture.*;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.CustomerDTOFixture.customerDTO;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartDTOFixture {

    public static Model<CartDTO> cartDTO() {
        var beverage = Instancio.create(cartItemBeverageDTO());
        var sandwich = Instancio.create(cartItemSandwichDTO());
        var sideDish = Instancio.create(cartItemSideDishDTO());


        return Instancio.of(CartDTO.class)
                .generate(field(CartDTO::getId), gen -> gen.text().uuid())
                .set(field(CartDTO::getCustomer), Instancio.create(customerDTO()))
                .set(field(CartDTO::getItems), List.of(beverage, sandwich, sideDish))
                .toModel();
    }

}
