package br.com.fiap.tech.challenge.driven.consumer.resource.response;

import br.com.fiap.tech.challenge.rest.common.response.Response;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class CartItemResponse extends Response {

    @Serial
    private static final long serialVersionUID = 5960662426733468603L;

    private ProductResponse product;

    private int quantity;

    private BigDecimal total;

    private BigDecimal subtotal;

    private BigDecimal discount;
}