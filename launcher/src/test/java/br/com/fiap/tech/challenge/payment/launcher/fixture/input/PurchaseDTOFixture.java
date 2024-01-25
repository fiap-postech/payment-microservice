package br.com.fiap.tech.challenge.payment.launcher.fixture.input;

import br.com.fiap.tech.challenge.adapter.dto.PurchaseDTO;
import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.List;

import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.CustomerDTOFixture.customerDTO;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.PaymentDTOFixture.paymentDTO;
import static br.com.fiap.tech.challenge.payment.launcher.fixture.input.PurchaseItemDTOFixture.*;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseDTOFixture {

    public static Model<PurchaseDTO> singleBeveragePurchaseDTO() {
        return Instancio.of(PurchaseDTO.class)
                .generate(field(PurchaseDTO::getId), gen -> gen.text().uuid())
                .generate(field(PurchaseDTO::getDate), gen -> gen.temporal().localDate())
                .set(field(PurchaseDTO::getItems), List.of(Instancio.create(singleBeverageItemDTO())))
                .set(field(PurchaseDTO::getCustomer), Instancio.create(customerDTO()))
                .set(field(PurchaseDTO::getPayment), Instancio.create(paymentDTO()))
                .set(field(PurchaseDTO::getStatus), PurchaseStatus.PAID)
                .toModel();
    }

    public static Model<PurchaseDTO> singleSideDishPurchaseDTO() {
        return Instancio.of(singleBeveragePurchaseDTO())
                .set(field(PurchaseDTO::getItems), List.of(Instancio.create(singleSideDishItemDTO())))
                .toModel();
    }

    public static Model<PurchaseDTO> singleSandwichPurchaseDTO() {
        return Instancio.of(singleBeveragePurchaseDTO())
                .set(field(PurchaseDTO::getItems), List.of(Instancio.create(singleSandwichItemDTO())))
                .toModel();
    }

    public static Model<PurchaseDTO> singleComboPurchaseDTO() {
        return Instancio.of(singleBeveragePurchaseDTO())
                .set(field(PurchaseDTO::getItems), List.of(Instancio.create(singleComboItemDTO())))
                .toModel();
    }

    public static Model<PurchaseDTO> sandwichAndBeveragePurchaseDTO() {
        return Instancio.of(singleBeveragePurchaseDTO())
                .set(field(PurchaseDTO::getItems), List.of(
                        Instancio.create(singleSandwichItemDTO()),
                        Instancio.create(singleBeverageItemDTO())
                ))
                .toModel();
    }

    public static Model<PurchaseDTO> comboAndSandwichAndBeveragePurchaseDTO() {
        return Instancio.of(singleBeveragePurchaseDTO())
                .set(field(PurchaseDTO::getItems), List.of(
                        Instancio.create(singleSandwichItemDTO()),
                        Instancio.create(singleBeverageItemDTO()),
                        Instancio.create(singleComboItemDTO())
                ))
                .toModel();
    }



}
