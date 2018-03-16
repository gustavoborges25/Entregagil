package com.time06.escoladeti.anuncio.command.domestico;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioAnimalCommand extends CriarAnuncioCommand {

    private String tipo;
    private String nome;
    private String raca;
    private Double peso;
    private Double altura;
    private Boolean vacinacaoEmDia;
    private Boolean possuiTodosRegistros;
    private Boolean possuiCaixaTranporte;

    @JsonCreator
    public CriarAnuncioAnimalCommand(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("enderecoOrigem") CriarEnderecoCommand enderecoOrigem,
            @JsonProperty("enderecoDestino") CriarEnderecoCommand enderecoDestino,
            @JsonProperty("dataValidade") Date dataValidade,
            @JsonProperty("contatoOrigem") String contatoOrigem,
            @JsonProperty("telefoneOrigem") String telefoneOrigem,
            @JsonProperty("contatoDestino") String contatoDestino,
            @JsonProperty("telefoneDestino") String telefoneDestino,
            @JsonProperty("observacao") String observacao,
            @JsonProperty("tipo") String tipo,
            @JsonProperty("nome") String nome,
            @JsonProperty("raca") String raca,
            @JsonProperty("peso") Double peso,
            @JsonProperty("altura") Double altura,
            @JsonProperty("vacinacaoEmDia") Boolean vacinacaoEmDia,
            @JsonProperty("possuiTodosRegistros") Boolean possuiTodosRegistros,
            @JsonProperty("possuiCaixaTranporte") Boolean possuiCaixaTranporte,
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);
        this.tipo = tipo;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.altura = altura;
        this.vacinacaoEmDia = vacinacaoEmDia;
        this.possuiTodosRegistros = possuiTodosRegistros;
        this.possuiCaixaTranporte = possuiCaixaTranporte;
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

    public Boolean getPossuiCaixaTranporte() {
        return possuiCaixaTranporte;
    }

}