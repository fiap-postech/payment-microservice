package br.com.fiap.tech.challenge.adapter.driven.mongodb.model;

import br.com.fiap.tech.challenge.enterprise.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "payment")
@Setter
@Getter
public class PaymentEntity {

    private String uuid;

    private PurchaseEntity purchase;

    private String method;

    private LocalDate date;

    private PaymentStatus status;

    private BigDecimal amount;
}
