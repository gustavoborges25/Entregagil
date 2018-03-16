package com.time06.escoladeti.infraestrutura.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogarCommand {

    private String email;
    private String senha;

    @JsonCreator
    public LogarCommand(@JsonProperty("email") String email
                      , @JsonProperty("senha") String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}