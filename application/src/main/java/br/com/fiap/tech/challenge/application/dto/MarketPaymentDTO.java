package br.com.fiap.tech.challenge.application.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
public class MarketPaymentDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 8246412417021354380L;

    private String purchaseUUID;

    private String statusMarketPayment;
}
