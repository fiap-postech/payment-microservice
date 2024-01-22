package br.com.fiap.tech.challenge.driven.consumer.resource.response;

import br.com.fiap.tech.challenge.rest.common.response.Response;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
public class CartResponse extends Response {
    @Serial
    private static final long serialVersionUID = 1464909268054662495L;

    private String id;

    private BigDecimal total;

    private BigDecimal subtotal;

    private BigDecimal discount;

    private CustomerResponse customer;

    private List<CartItemResponse> items;
}
