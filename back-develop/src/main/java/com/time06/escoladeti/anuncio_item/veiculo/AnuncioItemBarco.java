package com.time06.escoladeti.anuncio_item.veiculo;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoBarco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
public class AnuncioItemBarco extends AnuncioItem {

    @NomeFrontEnd(nome = "Marca")
    @Column(name = "marca")
    private String marca;

    @NomeFrontEnd(nome = "Modelo")
    @Column(name = "modelo")
    private String modelo;

    @NomeFrontEnd(nome = "Largura")
    @Column(name = "largura")
    private Double largura;

    @NomeFrontEnd(nome = "Altura")
    @Column(name = "altura")
    private Double altura;

    @NomeFrontEnd(nome = "Comprimento")
    @Column(name = "comprimento")
    private Double comprimento;

    @NomeFrontEnd(nome = "Peso")
    @Column(name = "peso")
    private Double peso;

    @NomeFrontEnd(nome = "No reboque?")
    @Column(name = "no_reboque")
    private Boolean noReboque;

    @NomeFrontEnd(nome = "Tipo do Barco")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_barco")
    private TipoBarco tipoBarco;

    protected AnuncioItemBarco() {
    }

    public AnuncioItemBarco(Anuncio anuncio, List<String> foto, String observacao, String marca, String modelo, Double largura, Double altura, Double comprimento, Double peso, Boolean noReboque, TipoBarco tipoBarco) {
        super(anuncio, foto, observacao);
        this.marca = marca;
        this.modelo = modelo;
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.noReboque = noReboque;
        this.tipoBarco = tipoBarco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public Double getPeso() {
        return peso;
    }

    public Boolean getNoReboque() {
        return noReboque;
    }

    public TipoBarco getTipoBarco() {
        return tipoBarco;
    }
}
