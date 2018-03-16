package com.time06.escoladeti.usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateUsuarioCommand {

    private String idUsuario;
    private String idPessoa;
    private String telefone;
    private String celular;
    private CriarEnderecoCommand endereco;

    @JsonCreator
    public UpdateUsuarioCommand(
            @JsonProperty("idUsuario") String idUsuario,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("telefone") String telefone,
            @JsonProperty("celular") String celular,
            @JsonProperty("endereco") CriarEnderecoCommand endereco) {
        this.idUsuario = idUsuario;
        this.idPessoa = idPessoa;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCelular() {
        return celular;
    }

    public CriarEnderecoCommand getEndereco() {
        return endereco;
    }
}