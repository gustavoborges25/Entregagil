package com.time06.escoladeti.anuncio_item.carga;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemCargaCompleta extends AnuncioItemCarga {

    @NomeFrontEnd(nome = "Embalagem")
    @Column(name = "embalagem")
    private String embalagem;

    @NomeFrontEnd(nome = "Precisa Pagar Descarga?")
    @Column(name = "precisaPagarDescarga")
    private Boolean precisaPagarDescarga;

    protected AnuncioItemCargaCompleta() {
    }

    public AnuncioItemCargaCompleta(Anuncio anuncio, List<String> foto, String observacao, String tipo, Double peso, String embalagem, Boolean precisaPagarDescarga) {
        super(anuncio, foto, observacao, tipo, peso);
        this.embalagem = embalagem;
        this.precisaPagarDescarga = precisaPagarDescarga;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public Boolean getPrecisaPagarDescarga() {
        return precisaPagarDescarga;
    }
}
