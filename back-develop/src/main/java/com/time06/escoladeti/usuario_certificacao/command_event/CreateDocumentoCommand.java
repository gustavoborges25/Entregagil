package com.time06.escoladeti.usuario_certificacao.command_event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateDocumentoCommand {

    private String nome;
    private String arquivo;

    @JsonCreator
    public CreateDocumentoCommand(
            @JsonProperty("nome") String nome,
            @JsonProperty("arquivo") String arquivo) {

        this.nome = nome;
        this.arquivo = arquivo;

    }

    public String getNome() {
        return nome;
    }

    public String getArquivo() {
        return arquivo;
    }

}