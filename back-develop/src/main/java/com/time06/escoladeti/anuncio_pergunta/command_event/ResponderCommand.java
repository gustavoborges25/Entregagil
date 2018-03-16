package com.time06.escoladeti.anuncio_pergunta.command_event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponderCommand {

    private String idPergunta;
    private String idPessoa;
    private String conteudo;

    @JsonCreator
    public ResponderCommand(
            @JsonProperty("idPergunta") String idPergunta,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("conteudo") String conteudo) {
        this.idPergunta = idPergunta;
        this.idPessoa = idPessoa;
        this.conteudo = conteudo;
    }

    public String getIdPergunta() {
        return idPergunta;
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public String getConteudo() {
        return conteudo;
    }

}