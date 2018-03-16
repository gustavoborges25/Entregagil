package com.time06.escoladeti.anuncio_item.veiculo;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoAgricola;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
public class AnuncioItemAgricola extends AnuncioItem {

    @NomeFrontEnd(nome = "Especificação do Veículo")
    @Column(name = "especificacao_veiculo")
    private String especificacaoVeiculo;

    @NomeFrontEnd(nome = "Marca")
    @Column(name = "marca")
    private String marca;

    @NomeFrontEnd(nome = "Modelo")
    @Column(name = "modelo")
    private String modelo;

    @NomeFrontEnd(nome = "No reboque?")
    @Column(name = "no_reboque")
    private Boolean noReboque;

    @NomeFrontEnd(nome = "Tipo agrícola")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_agricola")
    private TipoAgricola tipoAgricola;

    protected AnuncioItemAgricola() {
    }

    public AnuncioItemAgricola(Anuncio anuncio, List<String> foto, String observacao, String especificacaoVeiculo, String marca, String modelo, Boolean noReboque, TipoAgricola tipoAgricola) {
        super(anuncio, foto, observacao);
        this.especificacaoVeiculo = especificacaoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.noReboque = noReboque;
        this.tipoAgricola = tipoAgricola;
    }

    public String getEspecificacaoVeiculo() {
        return especificacaoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Boolean getNoReboque() {
        return noReboque;
    }

    public TipoAgricola getTipoAgricola() {
        return tipoAgricola;
    }
}
