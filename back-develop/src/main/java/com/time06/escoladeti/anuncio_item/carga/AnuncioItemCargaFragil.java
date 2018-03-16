package com.time06.escoladeti.anuncio_item.carga;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemCargaFragil extends AnuncioItemCarga {

    @NomeFrontEnd(nome = "Embalagem")
    @Column(name = "embalagem")
    private String embalagem;

    protected AnuncioItemCargaFragil() {
    }

    public AnuncioItemCargaFragil(Anuncio anuncio, List<String> foto, String observacao, String tipo, Double peso, String embalagem) {
        super(anuncio, foto, observacao, tipo, peso);
        this.embalagem = embalagem;
    }

    public String getEmbalagem() {
        return embalagem;
    }
}
