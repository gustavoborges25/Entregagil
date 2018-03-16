package com.time06.escoladeti.anuncio_item.mudanca;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.anuncio_item.mudanca.tipos.TipoEscritorio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.List;

@Entity
public class AnuncioItemMudancaComercialEscritorio extends AnuncioItemMudancaComercial {

    @NomeFrontEnd(nome = "Escritório térreo/prédio")
    @Enumerated(EnumType.STRING)
    @Column(name = "terreo_predio")
    private TipoEscritorio terreoPredio;

    protected AnuncioItemMudancaComercialEscritorio() {
    }

    public AnuncioItemMudancaComercialEscritorio(Anuncio anuncio, List<String> foto, String observacao, String restricaoHorarioInicial, String restricaoHorarioFinal, Integer qtdeItens, String itens, TipoEscritorio terreoPredio) {
        super(anuncio, foto, observacao, restricaoHorarioInicial, restricaoHorarioFinal, qtdeItens, itens);
        this.terreoPredio = terreoPredio;
    }

    public TipoEscritorio getTerreoPredio() {
        return terreoPredio;
    }

}
