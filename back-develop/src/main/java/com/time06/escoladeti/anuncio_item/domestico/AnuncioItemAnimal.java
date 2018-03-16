package com.time06.escoladeti.anuncio_item.domestico;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class AnuncioItemAnimal extends AnuncioItem {

    @NomeFrontEnd(nome = "Tipo")
    @Column(name = "tipo")
    private String tipo;

    @NomeFrontEnd(nome = "Nome")
    @Column(name = "nome")
    private String nome;

    @NomeFrontEnd(nome = "Raça")
    @Column(name = "raca")
    private String raca;

    @NomeFrontEnd(nome = "Peso")
    @Column(name = "peso")
    private Double peso;

    @NomeFrontEnd(nome = "Altura")
    @Column(name = "altura")
    private Double altura;

    @NomeFrontEnd(nome = "Vacinação em dia?")
    @Column(name = "vacinacao_em_dia")
    private Boolean vacinacaoEmDia;

    @NomeFrontEnd(nome = "Possui todos os registros?")
    @Column(name = "possui_todos_registros")
    private Boolean possuiTodosRegistros;

    @NomeFrontEnd(nome = "Possui caixa de transporte?")
    @Column(name = "possui_caixa_transporte")
    private Boolean possuiCaixaTransporte;

    protected AnuncioItemAnimal() {
    }

    public AnuncioItemAnimal(Anuncio anuncio, List<String> foto, String observacao, String tipo, String nome, String raca, Double peso, Double altura, Boolean vacinacaoEmDia, Boolean possuiTodosRegistros, Boolean possuiCaixaTransporte) {
        super(anuncio, foto, observacao);
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.altura = altura;
        this.vacinacaoEmDia = vacinacaoEmDia;
        this.possuiTodosRegistros = possuiTodosRegistros;
        this.possuiCaixaTransporte = possuiCaixaTransporte;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getRaca() {
        return raca;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    public Boolean getVacinacaoEmDia() {
        return vacinacaoEmDia;
    }

    public Boolean getPossuiTodosRegistros() {
        return possuiTodosRegistros;
    }

    public Boolean getPossuiCaixaTransporte() {
        return possuiCaixaTransporte;
    }

}
