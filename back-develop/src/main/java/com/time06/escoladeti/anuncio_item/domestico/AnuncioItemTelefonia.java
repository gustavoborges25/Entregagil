package com.time06.escoladeti.anuncio_item.domestico;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemTelefonia extends AnuncioItem {

    @NomeFrontEnd(nome = "Marca")
    @Column(name = "marca")
    private String marca;

    @NomeFrontEnd(nome = "Modelo")
    @Column(name = "modelo")
    private String modelo;

    @NomeFrontEnd(nome = "Embalagem")
    @Column(name = "embalagem")
    private String embalagem;

    @NomeFrontEnd(nome = "Altua")
    @Column(name = "altura")
    private Double altura;

    @NomeFrontEnd(nome = "Largura")
    @Column(name = "largura")
    private Double largura;

    @NomeFrontEnd(nome = "Comprimento")
    @Column(name = "comprimento")
    private Double comprimento;

    @NomeFrontEnd(nome = "Peso")
    @Column(name = "peso")
    private Double peso;

    protected AnuncioItemTelefonia() {
    }

    public AnuncioItemTelefonia(Anuncio anuncio, List<String> foto, String observacao, String marca, String modelo, String embalagem, Double altura, Double largura, Double comprimento, Double peso) {
        super(anuncio, foto, observacao);
        this.marca = marca;
        this.modelo = modelo;
        this.embalagem = embalagem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public Double getPeso() {
        return peso;
    }

}
