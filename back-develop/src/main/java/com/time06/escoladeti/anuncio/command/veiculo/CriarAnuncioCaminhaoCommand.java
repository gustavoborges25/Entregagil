package com.time06.escoladeti.anuncio.command.veiculo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.anuncio_item.veiculo.tipos.TipoCaminhao;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioCaminhaoCommand extends CriarAnuncioCommand {

    private String marca;
    private String modelo;
    private Boolean noReboque;
    private TipoCaminhao tipoCaminhao;

    @JsonCreator
    public CriarAnuncioCaminhaoCommand(
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
            @JsonProperty("noReboque") Boolean noReboque,
            @JsonProperty("tipoCaminhao") TipoCaminhao tipoCaminhao,
            @JsonProperty("observacao") String observacao,
            @JsonProperty("fotos") List<String> fotos) {

        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);

        this.marca = marca;
        this.modelo = modelo;
        this.noReboque = noReboque;
        this.tipoCaminhao = tipoCaminhao;
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

    public TipoCaminhao getTipoCaminhao() {
        return tipoCaminhao;
    }

}
