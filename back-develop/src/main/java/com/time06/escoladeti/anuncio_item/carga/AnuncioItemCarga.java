package com.time06.escoladeti.anuncio_item.carga;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemCarga extends AnuncioItem {

    @NomeFrontEnd(nome = "Tipo")
    @Column(name = "tipo")
    private String tipo;

    @NomeFrontEnd(nome = "Peso")
    @Column(name = "peso")
    private Double peso;

    protected AnuncioItemCarga() {
    }

    public AnuncioItemCarga(Anuncio anuncio, List<String> foto, String observacao, String tipo, Double peso) {
        super(anuncio, foto, observacao);
        this.tipo = tipo;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPeso() {
        return peso;
    }

}
