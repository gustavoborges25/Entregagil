package com.time06.escoladeti.pessoa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

public class AlterarPessoaCommand {

    private String id;
    private String dataCadastro;
    private String tipoPessoa;
    private String telefone;
    private String celular;
    private String foto;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private CriarEnderecoCommand endereco;

    @JsonCreator
    public AlterarPessoaCommand(
            @JsonProperty("id") String id,
            @JsonProperty("dataCadastro") String dataCadastro,
            @JsonProperty("tipoPessoa") String tipoPessoa,
            @JsonProperty("telefone") String telefone,
            @JsonProperty("celular") String celular,
            @JsonProperty("foto") String foto,
            @JsonProperty("nome") String nome,
            @JsonProperty("sobrenome") String sobrenome,
            @JsonProperty("cpf") String cpf,
            @JsonProperty("rg") String rg,
            @JsonProperty("endereco") CriarEnderecoCommand endereco) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.tipoPessoa = tipoPessoa;
        this.telefone = telefone;
        this.celular = celular;
        this.foto = foto;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
    }

    public String getId() {
        return id;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public String getFoto() {
        return foto;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public CriarEnderecoCommand getEndereco() {
        return endereco;
    }

}