package com.time06.escoladeti.anuncio_item.carga;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemCargaContainer extends AnuncioItemCarga {

    @NomeFrontEnd(nome = "Altura")
    @Column(name = "altura")
    private Double altura;

    @NomeFrontEnd(nome = "Largura")
    @Column(name = "largura")
    private Double largura;

    @NomeFrontEnd(nome = "Comprimento")
    @Column(name = "comprimento")
    private Double comprimento;

    protected AnuncioItemCargaContainer() {
    }

    public AnuncioItemCargaContainer(Anuncio anuncio, List<String> foto, String observacao, String tipo, Double peso, Double altura, Double largura, Double comprimento) {
        super(anuncio, foto, observacao, tipo, peso);
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
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
