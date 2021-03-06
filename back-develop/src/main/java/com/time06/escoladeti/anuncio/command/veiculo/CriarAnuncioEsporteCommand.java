package com.time06.escoladeti.anuncio.command.veiculo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioEsporteCommand extends CriarAnuncioCommand {

    private String tipo;
    private Double altura;
    private Double largura;
    private Double comprimento;
    private Double peso;

    @JsonCreator
    public CriarAnuncioEsporteCommand(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("enderecoOrigem") CriarEnderecoCommand enderecoOrigem,
            @JsonProperty("enderecoDestino") CriarEnderecoCommand enderecoDestino,
            @JsonProperty("dataValidade") Date dataValidade,
            @JsonProperty("contatoOrigem") String contatoOrigem,
            @JsonProperty("telefoneOrigem") String telefoneOrigem,
            @JsonProperty("contatoDestino") String contatoDestino,
            @JsonProperty("telefoneDestino") String telefoneDestino,
            @JsonProperty("tipo") String tipo,
            @JsonProperty("altura") Double altura,
            @JsonProperty("largura") Double largura,
            @JsonProperty("comprimento") Double comprimento,
            @JsonProperty("peso") Double peso,
            @JsonProperty("observacao") String observacao,
            @JsonProperty("fotos") List<String> fotos) {

        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);

        this.tipo = tipo;
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
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

    public Double getPeso() {
        return peso;
    }
}
