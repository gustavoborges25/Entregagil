package com.time06.escoladeti.endereco;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarEnderecoCommand {

    private String id;
    private String cep;
    private String endereco;
    private String numero;
    private String bairro;
    private String tipoEndereco;
    private String complemento;
    private String cidade;
    private String estado;
    private String pais;

    public CriarEnderecoCommand(
            @JsonProperty("id") String id,
            @JsonProperty("cep") String cep,
            @JsonProperty("endereco") String endereco,
            @JsonProperty("numero") String numero,
            @JsonProperty("bairro") String bairro,
            @JsonProperty("tipoEndereco") String tipoEndereco,
            @JsonProperty("complemento") String complemento,
            @JsonProperty("cidade") String cidade,
            @JsonProperty("estado") String estado,
            @JsonProperty("pais") String pais) {
        this.id = id;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.tipoEndereco = tipoEndereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public String getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

}