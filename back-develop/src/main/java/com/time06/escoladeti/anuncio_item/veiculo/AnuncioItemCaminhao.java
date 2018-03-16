package com.time06.escoladeti.anuncio_item.veiculo;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoCaminhao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
public class AnuncioItemCaminhao extends AnuncioItem {

    @NomeFrontEnd(nome = "Marca")
    @Column(name = "marca")
    private String marca;

    @NomeFrontEnd(nome = "Modelo")
    @Column(name = "modelo")
    private String modelo;

    @NomeFrontEnd(nome = "No reboque?")
    @Column(name = "no_reboque")
    private Boolean noReboque;

    @NomeFrontEnd(nome = "Tipo do caminhão")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_caminhao")
    private TipoCaminhao tipoCaminhao;

    protected AnuncioItemCaminhao() {
    }

    public AnuncioItemCaminhao(Anuncio anuncio, List<String> foto, String observacao, String marca, String modelo, Boolean noReboque, TipoCaminhao tipoCaminhao) {
        super(anuncio, foto, observacao);
        this.marca = marca;
        this.modelo = modelo;
        this.noReboque = noReboque;
        this.tipoCaminhao = tipoCaminhao;
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

    public TipoCaminhao getTipoCaminhao() {
        return tipoCaminhao;
    }
}
