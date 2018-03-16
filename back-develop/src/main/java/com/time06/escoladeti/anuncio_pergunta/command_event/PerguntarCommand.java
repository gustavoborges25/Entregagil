package com.time06.escoladeti.anuncio_pergunta.command_event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PerguntarCommand {

    private String idAnuncio;
    private String idPessoa;
    private String conteudo;

    @JsonCreator
    public PerguntarCommand(
            @JsonProperty("idAnuncio") String idAnuncio,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("conteudo") String conteudo) {
        this.idAnuncio = idAnuncio;
        this.idPessoa = idPessoa;
        this.conteudo = conteudo;
    }

    public String getIdAnuncio() {
        return idAnuncio;
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public String getConteudo() {
        return conteudo;
    }

}