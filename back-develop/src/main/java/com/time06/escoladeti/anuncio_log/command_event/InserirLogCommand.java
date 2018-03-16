package com.time06.escoladeti.anuncio_log.command_event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio_log.entity.AnuncioLogStatus;

public class InserirLogCommand {

    private String idAnuncio;
    private AnuncioLogStatus status;
    private String local;

    @JsonCreator
    public InserirLogCommand(
            @JsonProperty("idAnuncio") String idAnuncio,
            @JsonProperty("status") AnuncioLogStatus status,
            @JsonProperty("local") String local) {
        this.idAnuncio = idAnuncio;
        this.status = status;
        this.local = local;
    }

    public String getIdAnuncio() {
        return idAnuncio;
    }

    public AnuncioLogStatus getStatus() {
        return status;
    }

    public String getLocal() {
        return local;
    }

}
