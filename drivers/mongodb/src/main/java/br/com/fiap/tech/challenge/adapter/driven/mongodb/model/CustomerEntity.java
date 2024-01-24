package br.com.fiap.tech.challenge.adapter.driven.mongodb.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerEntity {

    private String uuid;

    private String name;

    private String email;

    private String document;

    private boolean enabled;
}
