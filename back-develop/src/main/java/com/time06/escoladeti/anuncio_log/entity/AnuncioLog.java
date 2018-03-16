package com.time06.escoladeti.anuncio_log.entity;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.infraestrutura.ModeloBase;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AnuncioLog extends ModeloBase {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_anuncio",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Anuncio anuncio;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date data;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AnuncioLogStatus status;

    @Column(name = "local")
    private String local;

    @Column(name = "descricao")
    private String descricao;

    protected AnuncioLog() {
    }

    public AnuncioLog(Anuncio anuncio, Date data, AnuncioLogStatus status, String local) {
        this.anuncio = anuncio;
        this.data = data;
        this.status = status;
        this.local = local;
    }

    public AnuncioLog(Date data, AnuncioLogStatus status, String local) {
        this.data = data;
        this.status = status;
        this.local = local;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public Date getData() {
        return data;
    }

    public AnuncioLogStatus getStatus() {
        return status;
    }

    public String getLocal() {
        return local;
    }

    public String getDescricao() {
        return descricao;
    }

}
