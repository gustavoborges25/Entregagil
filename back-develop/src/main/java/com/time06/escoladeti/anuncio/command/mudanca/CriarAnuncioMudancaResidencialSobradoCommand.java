package com.time06.escoladeti.anuncio.command.mudanca;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioMudancaResidencialSobradoCommand extends CriarAnuncioMudancaResidencialCommand {

    private Integer qtdeAndares;

    @JsonCreator
    public CriarAnuncioMudancaResidencialSobradoCommand(
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
            @JsonProperty("qtdeDormitorios") Integer qtdeDormitorios,
            @JsonProperty("restricaoHoraInicial") String restricaoHoraInicial,
            @JsonProperty("restricaoHoraFinal") String restricaoHoraFinal,
            @JsonProperty("qtdeAbajur") Integer qtdeAbajur,
            @JsonProperty("qtdeArmarioArquivo") Integer qtdeArmarioArquivo,
            @JsonProperty("qtdeArmarioComum") Integer qtdeArmarioComum,
            @JsonProperty("qtdeAparelhoSom") Integer qtdeAparelhoSom,
            @JsonProperty("qtdeAspiradorPo") Integer qtdeAspiradorPo,
            @JsonProperty("qtdeArCondicionado") Integer qtdeArCondicionado,
            @JsonProperty("qtdeAquario") Integer qtdeAquario,
            @JsonProperty("qtdeBancoAlto") Integer qtdeBancoAlto,
            @JsonProperty("qtdeBancoVaranda") Integer qtdeBancoVaranda,
            @JsonProperty("qtdeBarzinho") Integer qtdeBarzinho,
            @JsonProperty("qtdeBau") Integer qtdeBau,
            @JsonProperty("qtdeBerco") Integer qtdeBerco,
            @JsonProperty("qtdeBicicleta") Integer qtdeBicicleta,
            @JsonProperty("qtdeCadeira") Integer qtdeCadeira,
            @JsonProperty("qtdeCamaSolteiro") Integer qtdeCamaSolteiro,
            @JsonProperty("qtdeCamaCasal") Integer qtdeCamaCasal,
            @JsonProperty("qtdeCamaBeliche") Integer qtdeCamaBeliche,
            @JsonProperty("qtdeComoda") Integer qtdeComoda,
            @JsonProperty("qtdeCarrinhoMao") Integer qtdeCarrinhoMao,
            @JsonProperty("qtdeChurrasqueira") Integer qtdeChurrasqueira,
            @JsonProperty("qtdeCaixaRoupas") Integer qtdeCaixaRoupas,
            @JsonProperty("qtdeCaixasPequenas") Integer qtdeCaixasPequenas,
            @JsonProperty("qtdeCaixasMedias") Integer qtdeCaixasMedias,
            @JsonProperty("qtdeCaixasGrandes") Integer qtdeCaixasGrandes,
            @JsonProperty("qtdeCristaleira") Integer qtdeCristaleira,
            @JsonProperty("qtdeEstante") Integer qtdeEstante,
            @JsonProperty("qtdeEscrivaninha") Integer qtdeEscrivaninha,
            @JsonProperty("qtdeEspelho") Integer qtdeEspelho,
            @JsonProperty("qtdeFogao") Integer qtdeFogao,
            @JsonProperty("qtdeFrigobar") Integer qtdeFrigobar,
            @JsonProperty("qtdeFreezer") Integer qtdeFreezer,
            @JsonProperty("qtdeGuardaRoupa") Integer qtdeGuardaRoupa,
            @JsonProperty("qtdeGuardaSol") Integer qtdeGuardaSol,
            @JsonProperty("qtdeInstrumentoMusical") Integer qtdeInstrumentoMusical,
            @JsonProperty("qtdeLuminaria") Integer qtdeLuminaria,
            @JsonProperty("qtdeLixeira") Integer qtdeLixeira,
            @JsonProperty("qtdeLavaLoucas") Integer qtdeLavaLoucas,
            @JsonProperty("qtdeLavaRoupas") Integer qtdeLavaRoupas,
            @JsonProperty("qtdeMesaMadeira") Integer qtdeMesaMadeira,
            @JsonProperty("qtdeMesaVidro") Integer qtdeMesaVidro,
            @JsonProperty("qtdeMesaCentro") Integer qtdeMesaCentro,
            @JsonProperty("qtdeMicroondas") Integer qtdeMicroondas,
            @JsonProperty("qtdePiano") Integer qtdePiano,
            @JsonProperty("qtdePoltrona") Integer qtdePoltrona,
            @JsonProperty("qtdePrateleira") Integer qtdePrateleira,
            @JsonProperty("qtdePenteadeira") Integer qtdePenteadeira,
            @JsonProperty("qtdeRack") Integer qtdeRack,
            @JsonProperty("qtdeRefrigerador") Integer qtdeRefrigerador,
            @JsonProperty("qtdeSofa") Integer qtdeSofa,
            @JsonProperty("qtdeSecadoraRoupas") Integer qtdeSecadoraRoupas,
            @JsonProperty("qtdeTelevisao") Integer qtdeTelevisao,
            @JsonProperty("qtdeTabuaPassar") Integer qtdeTabuaPassar,
            @JsonProperty("outrosItens") String outrosItens,
            @JsonProperty("qtdeAndares") Integer qtdeAndares,
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, qtdeDormitorios, restricaoHoraInicial, restricaoHoraFinal, qtdeAbajur, qtdeArmarioArquivo, qtdeArmarioComum, qtdeAparelhoSom, qtdeAspiradorPo, qtdeArCondicionado, qtdeAquario, qtdeBancoAlto, qtdeBancoVaranda, qtdeBarzinho, qtdeBau, qtdeBerco, qtdeBicicleta, qtdeCadeira, qtdeCamaSolteiro, qtdeCamaCasal, qtdeCamaBeliche, qtdeComoda, qtdeCarrinhoMao, qtdeChurrasqueira, qtdeCaixaRoupas, qtdeCaixasPequenas, qtdeCaixasMedias, qtdeCaixasGrandes, qtdeCristaleira, qtdeEstante, qtdeEscrivaninha, qtdeEspelho, qtdeFogao, qtdeFrigobar, qtdeFreezer, qtdeGuardaRoupa, qtdeGuardaSol, qtdeInstrumentoMusical, qtdeLuminaria, qtdeLixeira, qtdeLavaLoucas, qtdeLavaRoupas, qtdeMesaMadeira, qtdeMesaVidro, qtdeMesaCentro, qtdeMicroondas, qtdePiano, qtdePoltrona, qtdePrateleira, qtdePenteadeira, qtdeRack, qtdeRefrigerador, qtdeSofa, qtdeSecadoraRoupas, qtdeTelevisao, qtdeTabuaPassar, outrosItens, fotos);
        this.qtdeAndares = qtdeAndares;
    }

    public Integer getQtdeAndares() {
        return qtdeAndares;
    }

}