package com.time06.escoladeti.anuncio.command.mudanca;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

public class CriarAnuncioMudancaComercialCommand extends CriarAnuncioCommand {

    private String restricaoHorarioInicial;

    private String restricaoHorarioFinal;

    private Integer qtdeItens;

    private String itens;

    @JsonCreator
    public CriarAnuncioMudancaComercialCommand(
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
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);
        this.restricaoHorarioInicial = restricaoHorarioInicial;
        this.restricaoHorarioFinal = restricaoHorarioFinal;
        this.qtdeItens = qtdeItens;
        this.itens = itens;
    }

    public String getRestricaoHorarioInicial() {
        return restricaoHorarioInicial;
    }

    public String getRestricaoHorarioFinal() {
        return restricaoHorarioFinal;
    }

    public Integer getQtdeItens() {
        return qtdeItens;
    }

    public String getItens() {
        return itens;
    }

}
