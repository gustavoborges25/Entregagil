package com.time06.escoladeti.anuncio.command.veiculo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoAgricola;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioAgricolaCommand extends CriarAnuncioCommand {

    private String especificacaoVeiculo;
    private String marca;
    private String modelo;
    private Boolean noReboque;
    private TipoAgricola tipoAgricola;

    @JsonCreator
    public CriarAnuncioAgricolaCommand(
            @JsonProperty("titulo") String titulo,
            @JsonProperty("idPessoa") String idPessoa,
            @JsonProperty("enderecoOrigem") CriarEnderecoCommand enderecoOrigem,
            @JsonProperty("enderecoDestino") CriarEnderecoCommand enderecoDestino,
            @JsonProperty("dataValidade") Date dataValidade,
            @JsonProperty("contatoOrigem") String contatoOrigem,
            @JsonProperty("telefoneOrigem") String telefoneOrigem,
            @JsonProperty("contatoDestino") String contatoDestino,
            @JsonProperty("telefoneDestino") String telefoneDestino,
            @JsonProperty("especificacaoVeiculo") String especificacaoVeiculo,
            @JsonProperty("marca") String marca,
            @JsonProperty("modelo") String modelo,
            @JsonProperty("noReboque") Boolean noReboque,
            @JsonProperty("tipoAgricola") TipoAgricola tipoAgricola,
            @JsonProperty("observacao") String observacao,
            @JsonProperty("fotos") List<String> fotos) {

        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);

        this.especificacaoVeiculo = especificacaoVeiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.noReboque = noReboque;
        this.tipoAgricola = tipoAgricola;
    }

    public String getEspecificacaoVeiculo() {
        return especificacaoVeiculo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Boolean getNoReboque() {
        return noReboque;
    }

    public TipoAgricola getTipoAgricola() {
        return tipoAgricola;
    }
}
