package com.time06.escoladeti.anuncio.command.carga;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioCargaCompletaCommand extends CriarAnuncioCargaCommand {

    private String embalagem;
    private Boolean precisaPagarDescarga;

    @JsonCreator
    public CriarAnuncioCargaCompletaCommand(
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
            @JsonProperty("embalagem") String embalagem,
            @JsonProperty("precisaPagarDescarga") Boolean precisaPagarDescarga,
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, tipo, peso, fotos);
        this.embalagem = embalagem;
        this.precisaPagarDescarga = precisaPagarDescarga;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public Boolean getPrecisaPagarDescarga() {
        return precisaPagarDescarga;
    }
}
