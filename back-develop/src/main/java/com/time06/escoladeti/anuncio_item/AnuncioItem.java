package com.time06.escoladeti.anuncio_item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.infraestrutura.ModeloBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AnuncioItem extends ModeloBase {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_ANUNCIO", referencedColumnName = "ID", nullable=false)
    private Anuncio anuncio;

    @ElementCollection
    private List<String> foto;

    @Column(name = "observacao")
    private String observacao;

    protected AnuncioItem() {
    }

    public AnuncioItem(Anuncio anuncio, List<String> foto, String observacao) {
        this.anuncio = anuncio;
        this.foto = foto;
        this.observacao = observacao;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public List<String> getFoto() {
        return foto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setId(String id) {
        this.id = id;
    }
}