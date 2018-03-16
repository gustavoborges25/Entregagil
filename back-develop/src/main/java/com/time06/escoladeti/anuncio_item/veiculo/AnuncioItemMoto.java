package com.time06.escoladeti.anuncio_item.veiculo;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoMoto;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoTransporteAbertoFechado;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoTransporteGuinchoCegonha;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Entity
public class AnuncioItemMoto extends AnuncioItem {

    @NomeFrontEnd(nome = "Marca")
    @Column(name = "marca")
    private String marca;

    @NomeFrontEnd(nome = "Modelo")
    @Column(name = "modelo")
    private String modelo;

    @NomeFrontEnd(nome = "Tipo da Moto")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_moto")
    private TipoMoto tipoMoto;

    @NomeFrontEnd(nome = "Transporte aberto ou fechado")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transporte")
    private TipoTransporteAbertoFechado tipoTransporte;

    @NomeFrontEnd(nome = "Guincho ou Cegonha")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transporte_guincho_cegonha")
    private TipoTransporteGuinchoCegonha tipoTransporteGuinchoCegonha;

    protected AnuncioItemMoto() {
    }

    public AnuncioItemMoto(Anuncio anuncio, List<String> foto, String observacao, String marca, String modelo, TipoMoto tipoMoto, TipoTransporteAbertoFechado tipoTransporte, TipoTransporteGuinchoCegonha tipoTransporteGuinchoCegonha) {
        super(anuncio, foto, observacao);
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMoto = tipoMoto;
        this.tipoTransporte = tipoTransporte;
        this.tipoTransporteGuinchoCegonha = tipoTransporteGuinchoCegonha;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public TipoTransporteAbertoFechado getTipoTransporte() {
        return tipoTransporte;
    }

    public TipoTransporteGuinchoCegonha getTipoTransporteGuinchoCegonha() {
        return tipoTransporteGuinchoCegonha;
    }
}
