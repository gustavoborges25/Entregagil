package com.time06.escoladeti.anuncio_item.outro;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemOutro extends AnuncioItem {

    @NomeFrontEnd(nome = "Nome")
    @Column(name = "nome_item")
    private String nomeItem;

    @NomeFrontEnd(nome = "Altura")
    @Column(name = "altura")
    private Double altura;

    @NomeFrontEnd(nome = "Largura")
    @Column(name = "largura")
    private Double largura;

    @NomeFrontEnd(nome = "Comprimento")
    @Column(name = "comprimento")
    private Double comprimento;

    protected AnuncioItemOutro() {
    }

    public AnuncioItemOutro(Anuncio anuncio, List<String> foto, String observacao, String nomeItem, Double altura, Double largura, Double comprimento) {
        super(anuncio, foto, observacao);
        this.nomeItem = nomeItem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public String getNomeItem() {
        return nomeItem;
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

}
