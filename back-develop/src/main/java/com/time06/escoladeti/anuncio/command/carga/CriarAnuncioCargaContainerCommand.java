package com.time06.escoladeti.anuncio.command.carga;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioCargaContainerCommand extends CriarAnuncioCargaCommand {

    private Double altura;
    private Double largura;
    private Double comprimento;

    @JsonCreator
    public CriarAnuncioCargaContainerCommand(
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
            @JsonProperty("peso") Double peso,
            @JsonProperty("altura") Double altura,
            @JsonProperty("largura") Double largura,
            @JsonProperty("comprimento") Double comprimento,
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, tipo, peso, fotos);
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getComprimento() {
        return comprimento;
    }

}