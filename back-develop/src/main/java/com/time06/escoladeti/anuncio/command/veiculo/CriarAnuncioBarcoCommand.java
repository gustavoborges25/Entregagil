package com.time06.escoladeti.anuncio.command.veiculo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoBarco;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioBarcoCommand extends CriarAnuncioCommand {

    private String marca;
    private String modelo;
    private Double largura;
    private Double altura;
    private Double comprimento;
    private Double peso;
    private Boolean noReboque;
    private TipoBarco tipoBarco;

    @JsonCreator
    public CriarAnuncioBarcoCommand(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("enderecoOrigem") CriarEnderecoCommand enderecoOrigem,
            @JsonProperty("enderecoDestino") CriarEnderecoCommand enderecoDestino,
            @JsonProperty("dataValidade") Date dataValidade,
            @JsonProperty("contatoOrigem") String contatoOrigem,
            @JsonProperty("telefoneOrigem") String telefoneOrigem,
            @JsonProperty("contatoDestino") String contatoDestino,
            @JsonProperty("telefoneDestino") String telefoneDestino,
            @JsonProperty("marca") String marca,
            @JsonProperty("modelo") String modelo,
            @JsonProperty("largura") Double largura,
            @JsonProperty("altura") Double altura,
            @JsonProperty("comprimento") Double comprimento,
            @JsonProperty("peso") Double peso,
            @JsonProperty("noReboque") Boolean noReboque,
            @JsonProperty("tipoBarco") TipoBarco tipoBarco,
            @JsonProperty("observacao") String observacao,
            @JsonProperty("fotos") List<String> fotos) {

        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);

        this.marca = marca;
        this.modelo = modelo;
        this.largura = largura;
        this.altura = altura;
        this.comprimento = comprimento;
        this.peso = peso;
        this.noReboque = noReboque;
        this.tipoBarco = tipoBarco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Double getLargura() {
        return largura;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public Double getPeso() {
        return peso;
    }

    public Boolean getNoReboque() {
        return noReboque;
    }

    public TipoBarco getTipoBarco() {
        return tipoBarco;
    }
}
