package com.time06.escoladeti.pessoa_avaliacao.command_event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvaliarAnuncianteCommand {

    private String idAnunciante;
    private String idAvaliador;
    private Integer avaliacaoGeral;
    private Boolean recomenda;
    private String comentario;

    @JsonCreator
    public AvaliarAnuncianteCommand(
            @JsonProperty("idAnunciante") String idAnunciante,
            @JsonProperty("idAvaliador") String idAvaliador,
            @JsonProperty("avaliacaoGeral") Integer avaliacaoGeral,
            @JsonProperty("recomenda") Boolean recomenda,
            @JsonProperty("comentario") String comentario) {
        this.idAnunciante = idAnunciante;
        this.idAvaliador = idAvaliador;
        this.avaliacaoGeral = avaliacaoGeral;
        this.recomenda = recomenda;
        this.comentario = comentario;
    }

    public String getIdAnunciante() {
        return idAnunciante;
    }

    public String getIdAvaliador() {
        return idAvaliador;
    }

    public Integer getAvaliacaoGeral() {
        return avaliacaoGeral;
    }

    public Boolean getRecomenda() {
        return recomenda;
    }

    public String getComentario() {
        return comentario;
    }

}