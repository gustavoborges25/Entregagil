package com.time06.escoladeti.anuncio_item.veiculo;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemPeca extends AnuncioItem {

    @NomeFrontEnd(nome = "Tipo")
    @Column(name = "tipo")
    private String tipo;

    @NomeFrontEnd(nome = "Embalagem")
    @Column(name = "embalagem")
    private String embalagem;

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

    protected AnuncioItemPeca() {
    }

    public AnuncioItemPeca(Anuncio anuncio, List<String> foto, String observacao, String tipo, String embalagem, Double largura, Double altura, Double comprimento, Double peso) {
        super(anuncio, foto, observacao);
        this.tipo = tipo;
        this.embalagem = embalagem;
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEmbalagem() {
        return embalagem;
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

}
