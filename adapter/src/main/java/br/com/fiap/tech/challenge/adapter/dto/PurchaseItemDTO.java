package br.com.fiap.tech.challenge.adapter.dto;

import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PurchaseItemDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -3104288659566784282L;

    private String id;
    private String title;
    private String description;
    private ProductCategory categoryId;
    private Integer quantity;
    private String currencyId;
    private String unitPrice;
}