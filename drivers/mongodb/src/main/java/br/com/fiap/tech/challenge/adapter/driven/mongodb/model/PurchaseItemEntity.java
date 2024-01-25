package br.com.fiap.tech.challenge.adapter.driven.mongodb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseItemEntity {

    private ProductEntity product;

    @Transient
    private PurchaseEntity purchase;

    private Integer quantity;

    private BigDecimal price;

    private BigDecimal discount;

    public BigDecimal getFullPrice() {
        return getPrice().add(getDiscount());
    }
}
