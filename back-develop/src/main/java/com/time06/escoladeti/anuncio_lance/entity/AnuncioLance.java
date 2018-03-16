package com.time06.escoladeti.anuncio_lance.entity;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_lance.AnuncioLanceException;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.pessoa.Pessoa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class AnuncioLance extends ModeloBase {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_anuncio",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Anuncio anuncio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa_transportador",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Pessoa transportador;

    @Column(name = "estimativa", nullable = false)
    private Integer estimativa;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "bo_carga_fracionada", nullable = false)
    private Boolean cargaFracionada;

    @Column(name = "observacoes")
    private String observacoes;

    @Enumerated
    @Column(name = "tp_status", nullable = false)
    private AnuncioLanceStatus status;

    protected AnuncioLance() {
    }

    public AnuncioLance(Anuncio anuncio, Pessoa transportador, Integer estimativa, BigDecimal valor, Boolean cargaFracionada, String observacoes) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new AnuncioLanceException("Valor deve ser maior que 0,00.");
        }
        if (estimativa.compareTo(0) <= 0) {
            throw new AnuncioLanceException("Estimativa deve ser maior que 0.");
        }

        this.anuncio = anuncio;
        this.transportador = transportador;
        this.estimativa = estimativa;
        this.valor = valor;
        this.cargaFracionada = cargaFracionada;
        this.observacoes = observacoes;
        this.status = AnuncioLanceStatus.CADASTRADO;
    }

    public AnuncioLance(String id, Pessoa transportador, Date dataCadastro, Integer estimativa, Boolean cargaFracionada, String observacoes, AnuncioLanceStatus satus, BigDecimal valor) {
        this.id = id;
        this.transportador = transportador;
        this.dataCadastro = dataCadastro;
        this.estimativa = estimativa;
        this.cargaFracionada = cargaFracionada;
        this.observacoes = observacoes;
        this.status = status;
        this.valor = valor;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public Pessoa getTransportador() {
        return transportador;
    }

    public Integer getEstimativa() {
        return estimativa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Boolean getCargaFracionada() {
        return cargaFracionada;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public AnuncioLanceStatus getStatus() {
        return status;
    }

    public void aceitar(String idPessoaQueEstaAceitandoLance) {
        if (!anuncio.getAnunciante().getId().equals(idPessoaQueEstaAceitandoLance)) {
            throw new AnuncioLanceException("Apenas quem criou o anúncio pode aceitar lances.");
        }

        this.status = AnuncioLanceStatus.ACEITO;
    }

    public void cancelar(String idPessoaQueEstaCancelandoLance) {
        if (!getTransportador().getId().equals(idPessoaQueEstaCancelandoLance)) {
            throw new AnuncioLanceException("Apenas quem deu o lance pode excluí-lo.");
        }

        this.status = AnuncioLanceStatus.CANCELADO;
    }

    public AnuncioLance removeAnuncio() {
        return new AnuncioLance(null, transportador, estimativa, valor, cargaFracionada, observacoes);
    }

}