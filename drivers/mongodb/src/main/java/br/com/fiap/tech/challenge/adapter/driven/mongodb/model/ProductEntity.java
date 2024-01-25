package br.com.fiap.tech.challenge.adapter.driven.mongodb.model;

import br.com.fiap.tech.challenge.enterprise.enums.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductEntity {

    private String uuid;

    private String name;

    private String description;

    private BigDecimal price;

    private String image;

    private ProductCategory category;

    private boolean enabled;
}
