package com.time06.escoladeti.anuncio.command.mudanca;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioMudancaComercialIndustrialCommand extends CriarAnuncioMudancaComercialCommand {

    private Double tamanho;

    public CriarAnuncioMudancaComercialIndustrialCommand(
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
            @JsonProperty("restricaoHorarioInicial") String restricaoHorarioInicial,
            @JsonProperty("restricaoHorarioFinal") String restricaoHorarioFinal,
            @JsonProperty("qtdeItens") Integer qtdeItens,
            @JsonProperty("itens") String itens,
            @JsonProperty("tamanho") Double tamanh0,
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, restricaoHorarioInicial, restricaoHorarioFinal, qtdeItens, itens, fotos);
        this.tamanho = tamanho;
    }

    public Double getTamanho() {
        return tamanho;
    }

}
