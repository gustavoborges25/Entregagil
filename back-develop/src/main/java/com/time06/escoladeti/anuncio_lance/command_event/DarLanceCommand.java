package com.time06.escoladeti.anuncio_lance.command_event;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DarLanceCommand {

    private String idAnuncio;
    private String idTransportador;
    private BigDecimal valor;
    private Integer estimativa;
    private Boolean cargaFracionada;
    private String observacoes;

    public DarLanceCommand(
            @JsonProperty("idAnuncio") String idAnuncio,
            @JsonProperty("idTransportador") String idTransportador,
            @JsonProperty("valor") BigDecimal valor,
            @JsonProperty("estimativa") Integer estimativa,
            @JsonProperty("cargaFracionada") Boolean cargaFracionada,
            @JsonProperty("observacoes") String observacoes) {
        this.idAnuncio = idAnuncio;
        this.idTransportador = idTransportador;
        this.valor = valor;
        this.estimativa = estimativa;
        this.cargaFracionada = cargaFracionada != null ? cargaFracionada : false;
        this.observacoes = observacoes;
    }

    public String getIdAnuncio() {
        return idAnuncio;
    }

    public String getIdTransportador() {
        return idTransportador;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getEstimativa() {
        return estimativa;
    }

    public Boolean getCargaFracionada() {
        return cargaFracionada;
    }

    public String getObservacoes() {
        return observacoes;
    }

}