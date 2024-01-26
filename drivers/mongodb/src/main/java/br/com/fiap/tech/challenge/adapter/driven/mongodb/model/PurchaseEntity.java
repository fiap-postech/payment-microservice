package br.com.fiap.tech.challenge.adapter.driven.mongodb.model;

import br.com.fiap.tech.challenge.enterprise.enums.PurchaseStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PurchaseEntity {

    private String uuid;

    private String cartUUID;

    private CustomerEntity customer;

    private PurchaseStatus status;

    private LocalDate date;

    private List<PurchaseItemEntity> items = new ArrayList<>();

    public void setItems(List<PurchaseItemEntity> items) {
        this.items = items;
        this.items.forEach(i -> i.setPurchase(this));
    }
}
