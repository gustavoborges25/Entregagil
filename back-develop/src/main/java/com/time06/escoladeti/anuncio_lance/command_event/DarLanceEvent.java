package com.time06.escoladeti.anuncio_lance.command_event;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.usuario.Usuario;

public class DarLanceEvent {

    Anuncio anuncio;
    Pessoa transportador;
    Integer estimativa;
    Boolean cargaFracionada;
    String observacoes;

    public DarLanceEvent(Anuncio anuncio, Pessoa transportador, Integer estimativa, Boolean cargaFracionada, String observacoes) {
        this.anuncio = anuncio;
        this.transportador = transportador;
        this.estimativa = estimativa;
        this.cargaFracionada = cargaFracionada;
        this.observacoes = observacoes;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public Pessoa getTransportador() {
        return transportador;
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