package com.time06.escoladeti.infraestrutura.redefinir_senha;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitarRedefinicaoSenhaCommand {

    private String email;

    @JsonCreator
    public SolicitarRedefinicaoSenhaCommand(@JsonProperty("email") String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}