package com.time06.escoladeti.anuncio_pergunta.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.pessoa.Pessoa;

import javax.persistence.*;
import java.util.List;

@Entity
public class AnuncioPergunta extends ModeloBase {

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_anuncio",
            referencedColumnName = "id",
            insertable = true)
    private Anuncio anuncio;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pergunta",
            referencedColumnName = "id",
            insertable = true)
    private AnuncioPergunta pergunta;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Pessoa pessoa;

    @Column(name = "conteudo", nullable = false)
    private String conteudo;

    @OneToMany(mappedBy = "pergunta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AnuncioPergunta> respostas;

    protected AnuncioPergunta() {
    }

    public AnuncioPergunta(Anuncio anuncio, Pessoa pessoa, String conteudo) {
        this.anuncio = anuncio;
        this.pessoa = pessoa;
        this.conteudo = conteudo;
    }

    public AnuncioPergunta(AnuncioPergunta pergunta, Pessoa pessoa, String conteudo) {
        this.pergunta = pergunta;
        this.pessoa = pessoa;
        this.conteudo = conteudo;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public AnuncioPergunta getPergunta() {
        return pergunta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getConteudo() {
        return conteudo;
    }

    public List<AnuncioPergunta> getRespostas() {
        return respostas;
    }

}