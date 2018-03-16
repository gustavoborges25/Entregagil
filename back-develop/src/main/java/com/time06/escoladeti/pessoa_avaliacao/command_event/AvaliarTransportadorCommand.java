package com.time06.escoladeti.pessoa_avaliacao.command_event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AvaliarTransportadorCommand {

    private String idTransportador;
    private String idAvaliador;
    private Integer avaliacaoGeral;
    private Boolean recomenda;
    private Integer tempoDeEntrega;
    private Integer integridadeMercadoria;
    private String comentario;

    @JsonCreator
    public AvaliarTransportadorCommand(
            @JsonProperty("idTransportador") String idTransportador,
            @JsonProperty("idAvaliador") String idAvaliador,
            @JsonProperty("avaliacaoGeral") Integer avaliacaoGeral,
            @JsonProperty("recomenda") Boolean recomenda,
            @JsonProperty("tempoDeEntrega") Integer tempoDeEntrega,
            @JsonProperty("integridadeMercadoria") Integer integridadeMercadoria,
            @JsonProperty("comentario") String comentario) {
        this.idTransportador = idTransportador;
        this.idAvaliador = idAvaliador;
        this.avaliacaoGeral = avaliacaoGeral;
        this.recomenda = recomenda;
        this.tempoDeEntrega = tempoDeEntrega;
        this.integridadeMercadoria = integridadeMercadoria;
        this.comentario = comentario;
    }

    public String getIdTransportador() {
        return idTransportador;
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

    public Integer getTempoDeEntrega() {
        return tempoDeEntrega;
    }

    public Integer getIntegridadeMercadoria() {
        return integridadeMercadoria;
    }

    public String getComentario() {
        return comentario;
    }

}