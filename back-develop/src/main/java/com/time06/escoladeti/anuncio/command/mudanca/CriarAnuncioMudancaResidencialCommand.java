package com.time06.escoladeti.anuncio.command.mudanca;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;

import java.util.Date;
import java.util.List;

public class CriarAnuncioMudancaResidencialCommand extends CriarAnuncioCommand {

    private Integer qtdeDormitorios;

    private String restricaoHoraInicial;

    private String restricaoHoraFinal;

    private Integer qtdeAbajur;

    private Integer qtdeArmarioArquivo;

    private Integer qtdeArmarioComum;

    private Integer qtdeAparelhoSom;

    private Integer qtdeAspiradorPo;

    private Integer qtdeArCondicionado;

    private Integer qtdeAquario;

    private Integer qtdeBancoAlto;

    private Integer qtdeBancoVaranda;

    private Integer qtdeBarzinho;

    private Integer qtdeBau;

    private Integer qtdeBerco;

    private Integer qtdeBicicleta;

    private Integer qtdeCadeira;

    private Integer qtdeCamaSolteiro;

    private Integer qtdeCamaCasal;

    private Integer qtdeCamaBeliche;

    private Integer qtdeComoda;

    private Integer qtdeCarrinhoMao;

    private Integer qtdeChurrasqueira;

    private Integer qtdeCaixaRoupas;

    private Integer qtdeCaixasPequenas;

    private Integer qtdeCaixasMedias;

    private Integer qtdeCaixasGrandes;

    private Integer qtdeCristaleira;

    private Integer qtdeEstante;

    private Integer qtdeEscrivaninha;

    private Integer qtdeEspelho;

    private Integer qtdeFogao;

    private Integer qtdeFrigobar;

    private Integer qtdeFreezer;

    private Integer qtdeGuardaRoupa;

    private Integer qtdeGuardaSol;

    private Integer qtdeInstrumentoMusical;

    private Integer qtdeLuminaria;

    private Integer qtdeLixeira;

    private Integer qtdeLavaLoucas;

    private Integer qtdeLavaRoupas;

    private Integer qtdeMesaMadeira;

    private Integer qtdeMesaVidro;

    private Integer qtdeMesaCentro;

    private Integer qtdeMicroondas;

    private Integer qtdePiano;

    private Integer qtdePoltrona;

    private Integer qtdePrateleira;

    private Integer qtdePenteadeira;

    private Integer qtdeRack;

    private Integer qtdeRefrigerador;

    private Integer qtdeSofa;

    private Integer qtdeSecadoraRoupas;

    private Integer qtdeTelevisao;

    private Integer qtdeTabuaPassar;

    private String outrosItens;

    @JsonCreator
    public CriarAnuncioMudancaResidencialCommand(
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
            @JsonProperty("fotos") List<String> fotos) {
        super(titulo, idPessoa, enderecoOrigem, enderecoDestino, dataValidade, contatoOrigem, telefoneOrigem, contatoDestino, telefoneDestino, observacao, fotos);
        this.qtdeDormitorios = qtdeDormitorios;
        this.restricaoHoraInicial = restricaoHoraInicial;
        this.restricaoHoraFinal = restricaoHoraFinal;
        this.qtdeAbajur = qtdeAbajur;
        this.qtdeArmarioArquivo = qtdeArmarioArquivo;
        this.qtdeArmarioComum = qtdeArmarioComum;
        this.qtdeAparelhoSom = qtdeAparelhoSom;
        this.qtdeAspiradorPo = qtdeAspiradorPo;
        this.qtdeArCondicionado = qtdeArCondicionado;
        this.qtdeAquario = qtdeAquario;
        this.qtdeBancoAlto = qtdeBancoAlto;
        this.qtdeBancoVaranda = qtdeBancoVaranda;
        this.qtdeBarzinho = qtdeBarzinho;
        this.qtdeBau = qtdeBau;
        this.qtdeBerco = qtdeBerco;
        this.qtdeBicicleta = qtdeBicicleta;
        this.qtdeCadeira = qtdeCadeira;
        this.qtdeCamaSolteiro = qtdeCamaSolteiro;
        this.qtdeCamaCasal = qtdeCamaCasal;
        this.qtdeCamaBeliche = qtdeCamaBeliche;
        this.qtdeComoda = qtdeComoda;
        this.qtdeCarrinhoMao = qtdeCarrinhoMao;
        this.qtdeChurrasqueira = qtdeChurrasqueira;
        this.qtdeCaixaRoupas = qtdeCaixaRoupas;
        this.qtdeCaixasPequenas = qtdeCaixasPequenas;
        this.qtdeCaixasMedias = qtdeCaixasMedias;
        this.qtdeCaixasGrandes = qtdeCaixasGrandes;
        this.qtdeCristaleira = qtdeCristaleira;
        this.qtdeEstante = qtdeEstante;
        this.qtdeEscrivaninha = qtdeEscrivaninha;
        this.qtdeEspelho = qtdeEspelho;
        this.qtdeFogao = qtdeFogao;
        this.qtdeFrigobar = qtdeFrigobar;
        this.qtdeFreezer = qtdeFreezer;
        this.qtdeGuardaRoupa = qtdeGuardaRoupa;
        this.qtdeGuardaSol = qtdeGuardaSol;
        this.qtdeInstrumentoMusical = qtdeInstrumentoMusical;
        this.qtdeLuminaria = qtdeLuminaria;
        this.qtdeLixeira = qtdeLixeira;
        this.qtdeLavaLoucas = qtdeLavaLoucas;
        this.qtdeLavaRoupas = qtdeLavaRoupas;
        this.qtdeMesaMadeira = qtdeMesaMadeira;
        this.qtdeMesaVidro = qtdeMesaVidro;
        this.qtdeMesaCentro = qtdeMesaCentro;
        this.qtdeMicroondas = qtdeMicroondas;
        this.qtdePiano = qtdePiano;
        this.qtdePoltrona = qtdePoltrona;
        this.qtdePrateleira = qtdePrateleira;
        this.qtdePenteadeira = qtdePenteadeira;
        this.qtdeRack = qtdeRack;
        this.qtdeRefrigerador = qtdeRefrigerador;
        this.qtdeSofa = qtdeSofa;
        this.qtdeSecadoraRoupas = qtdeSecadoraRoupas;
        this.qtdeTelevisao = qtdeTelevisao;
        this.qtdeTabuaPassar = qtdeTabuaPassar;
        this.outrosItens = outrosItens;
    }

    public Integer getQtdeDormitorios() {
        return qtdeDormitorios;
    }

    public String getRestricaoHoraInicial() {
        return restricaoHoraInicial;
    }

    public String getRestricaoHoraFinal() {
        return restricaoHoraFinal;
    }

    public Integer getQtdeAbajur() {
        return qtdeAbajur;
    }

    public Integer getQtdeArmarioArquivo() {
        return qtdeArmarioArquivo;
    }

    public Integer getQtdeArmarioComum() {
        return qtdeArmarioComum;
    }

    public Integer getQtdeAparelhoSom() {
        return qtdeAparelhoSom;
    }

    public Integer getQtdeAspiradorPo() {
        return qtdeAspiradorPo;
    }

    public Integer getQtdeArCondicionado() {
        return qtdeArCondicionado;
    }

    public Integer getQtdeAquario() {
        return qtdeAquario;
    }

    public Integer getQtdeBancoAlto() {
        return qtdeBancoAlto;
    }

    public Integer getQtdeBancoVaranda() {
        return qtdeBancoVaranda;
    }

    public Integer getQtdeBarzinho() {
        return qtdeBarzinho;
    }

    public Integer getQtdeBau() {
        return qtdeBau;
    }

    public Integer getQtdeBerco() {
        return qtdeBerco;
    }

    public Integer getQtdeBicicleta() {
        return qtdeBicicleta;
    }

    public Integer getQtdeCadeira() {
        return qtdeCadeira;
    }

    public Integer getQtdeCamaSolteiro() {
        return qtdeCamaSolteiro;
    }

    public Integer getQtdeCamaCasal() {
        return qtdeCamaCasal;
    }

    public Integer getQtdeCamaBeliche() {
        return qtdeCamaBeliche;
    }

    public Integer getQtdeComoda() {
        return qtdeComoda;
    }

    public Integer getQtdeCarrinhoMao() {
        return qtdeCarrinhoMao;
    }

    public Integer getQtdeChurrasqueira() {
        return qtdeChurrasqueira;
    }

    public Integer getQtdeCaixaRoupas() {
        return qtdeCaixaRoupas;
    }

    public Integer getQtdeCaixasPequenas() {
        return qtdeCaixasPequenas;
    }

    public Integer getQtdeCaixasMedias() {
        return qtdeCaixasMedias;
    }

    public Integer getQtdeCaixasGrandes() {
        return qtdeCaixasGrandes;
    }

    public Integer getQtdeCristaleira() {
        return qtdeCristaleira;
    }

    public Integer getQtdeEstante() {
        return qtdeEstante;
    }

    public Integer getQtdeEscrivaninha() {
        return qtdeEscrivaninha;
    }

    public Integer getQtdeEspelho() {
        return qtdeEspelho;
    }

    public Integer getQtdeFogao() {
        return qtdeFogao;
    }

    public Integer getQtdeFrigobar() {
        return qtdeFrigobar;
    }

    public Integer getQtdeFreezer() {
        return qtdeFreezer;
    }

    public Integer getQtdeGuardaRoupa() {
        return qtdeGuardaRoupa;
    }

    public Integer getQtdeGuardaSol() {
        return qtdeGuardaSol;
    }

    public Integer getQtdeInstrumentoMusical() {
        return qtdeInstrumentoMusical;
    }

    public Integer getQtdeLuminaria() {
        return qtdeLuminaria;
    }

    public Integer getQtdeLixeira() {
        return qtdeLixeira;
    }

    public Integer getQtdeLavaLoucas() {
        return qtdeLavaLoucas;
    }

    public Integer getQtdeLavaRoupas() {
        return qtdeLavaRoupas;
    }

    public Integer getQtdeMesaMadeira() {
        return qtdeMesaMadeira;
    }

    public Integer getQtdeMesaVidro() {
        return qtdeMesaVidro;
    }

    public Integer getQtdeMesaCentro() {
        return qtdeMesaCentro;
    }

    public Integer getQtdeMicroondas() {
        return qtdeMicroondas;
    }

    public Integer getQtdePiano() {
        return qtdePiano;
    }

    public Integer getQtdePoltrona() {
        return qtdePoltrona;
    }

    public Integer getQtdePrateleira() {
        return qtdePrateleira;
    }

    public Integer getQtdePenteadeira() {
        return qtdePenteadeira;
    }

    public Integer getQtdeRack() {
        return qtdeRack;
    }

    public Integer getQtdeRefrigerador() {
        return qtdeRefrigerador;
    }

    public Integer getQtdeSofa() {
        return qtdeSofa;
    }

    public Integer getQtdeSecadoraRoupas() {
        return qtdeSecadoraRoupas;
    }

    public Integer getQtdeTelevisao() {
        return qtdeTelevisao;
    }

    public Integer getQtdeTabuaPassar() {
        return qtdeTabuaPassar;
    }

    public String getOutrosItens() {
        return outrosItens;
    }

}
