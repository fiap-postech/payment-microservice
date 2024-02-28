package br.com.fiap.tech.challenge.adapter.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PurchaseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8440508890936918851L;

    private String id;
    private BigDecimal total;
    private List<PurchaseItemDTO> items;
}
