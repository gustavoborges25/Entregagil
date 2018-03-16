package com.time06.escoladeti.infraestrutura.redefinir_senha;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AtualizarSenhaCommand {

    private String idUsuario;
    private String novaSenha;

    @JsonCreator
    public AtualizarSenhaCommand(@JsonProperty("idUsuario") String idUsuario, @JsonProperty("novaSenha") String novaSenha) {
        this.idUsuario = idUsuario;
        this.novaSenha = novaSenha;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

}