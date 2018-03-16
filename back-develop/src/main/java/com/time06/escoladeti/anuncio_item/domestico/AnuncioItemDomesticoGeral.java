package com.time06.escoladeti.anuncio_item.domestico;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemDomesticoGeral extends AnuncioItem {

    @NomeFrontEnd(nome = "Tipo")
    @Column(name = "tipo")
    private String tipo;

    @NomeFrontEnd(nome = "Embalagem")
    @Column(name = "embalagem")
    private String embalagem;

    @NomeFrontEnd(nome = "Altura")
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

    protected AnuncioItemDomesticoGeral() {
    }

    public AnuncioItemDomesticoGeral(Anuncio anuncio, List<String> foto, String observacao, String tipo, String embalagem, Double altura, Double largura, Double comprimento, Double peso) {
        super(anuncio, foto, observacao);
        this.tipo = tipo;
        this.embalagem = embalagem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
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
