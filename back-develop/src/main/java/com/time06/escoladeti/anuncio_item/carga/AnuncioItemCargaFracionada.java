package com.time06.escoladeti.anuncio_item.carga;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemCargaFracionada extends AnuncioItemCarga {

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

    protected AnuncioItemCargaFracionada() {
    }

    public AnuncioItemCargaFracionada(Anuncio anuncio, List<String> foto, String observacao, String tipo, Double peso, String embalagem, Double altura, Double largura, Double comprimento) {
        super(anuncio, foto, observacao, tipo, peso);
        this.embalagem = embalagem;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
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
}
