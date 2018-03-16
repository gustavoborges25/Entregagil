package com.time06.escoladeti.anuncio_item.mudanca;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.anuncio_item.mudanca.tipos.TipoEscritorio;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AnuncioItemMudancaComercialIndustrial extends AnuncioItemMudancaComercial {

    @NomeFrontEnd(nome = "Tamanho")
    @Column(name = "tamanho")
    private Double tamanho;

    protected AnuncioItemMudancaComercialIndustrial() {
    }

    public AnuncioItemMudancaComercialIndustrial(Anuncio anuncio, List<String> foto, String observacao, String restricaoHorarioInicial, String restricaoHorarioFinal, Integer qtdeItens, String itens, Double tamanho) {
        super(anuncio, foto, observacao, restricaoHorarioInicial, restricaoHorarioFinal, qtdeItens, itens);
        this.tamanho = tamanho;
    }

    public Double getTamanho() {
        return tamanho;
    }

}
