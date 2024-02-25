package br.com.fiap.tech.challenge.enterprise.valueobject;

import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.io.Serial;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class PurchaseItem extends ValueObject {
    @Serial
    private static final long serialVersionUID = -2071891141308689952L;

    @NotNull
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private ProductCategory categoryId;

    @NotNull
    private Integer quantity;

    @NotNull
    private String currencyId;

    @NotNull
    private String unitPrice;

    @Builder(toBuilder = true)
    public PurchaseItem(@NotNull String id,
                        @NotNull String title,
                        @NotNull String description,
                        @NotNull ProductCategory categoryId,
                        @NotNull Integer quantity,
                        @NotNull String currencyId,
                        @NotNull String unitPrice) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.currencyId = currencyId;
        this.unitPrice = unitPrice;

        validate();
    }
}
