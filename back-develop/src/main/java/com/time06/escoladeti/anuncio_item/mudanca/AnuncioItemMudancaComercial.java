package com.time06.escoladeti.anuncio_item.mudanca;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AnuncioItemMudancaComercial extends AnuncioItem {

    @NomeFrontEnd(nome = "Restrição de horário inicial")
    @Column(name = "restricao_horario_inicial")
    private String restricaoHorarioInicial;

    @NomeFrontEnd(nome = "Restrição de horário final")
    @Column(name = "restricao_horario_final")
    private String restricaoHorarioFinal;

    @NomeFrontEnd(nome = "Quantidade de itens")
    @Column(name = "qtde_itens")
    private Integer qtdeItens;

    @NomeFrontEnd(nome = "Itens")
    @Column(name = "itens")
    private String itens;

    protected AnuncioItemMudancaComercial() {
    }

    public AnuncioItemMudancaComercial(Anuncio anuncio, List<String> foto, String observacao, String restricaoHorarioInicial, String restricaoHorarioFinal, Integer qtdeItens, String itens) {
        super(anuncio, foto, observacao);
        this.restricaoHorarioInicial = restricaoHorarioInicial;
        this.restricaoHorarioFinal = restricaoHorarioFinal;
        this.qtdeItens = qtdeItens;
        this.itens = itens;
    }

    public String getRestricaoHorarioInicial() {
        return restricaoHorarioInicial;
    }

    public String getRestricaoHorarioFinal() {
        return restricaoHorarioFinal;
    }

    public Integer getQtdeItens() {
        return qtdeItens;
    }

    public String getItens() {
        return itens;
    }

}