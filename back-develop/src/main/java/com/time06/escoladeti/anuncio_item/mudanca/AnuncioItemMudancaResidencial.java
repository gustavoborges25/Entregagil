package com.time06.escoladeti.anuncio_item.mudanca;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AnuncioItemMudancaResidencial extends AnuncioItem {

    @NomeFrontEnd(nome = "Qtde. dormitório")
    @Column(name = "qtde_dormitorios")
    private Integer qtdeDormitorios;

    @NomeFrontEnd(nome = "Restrição de horário inicial")
    @Column(name = "restricao_hora_inicial")
    private String restricaoHoraInicial;

    @NomeFrontEnd(nome = "Restrição de horário final")
    @Column(name = "restricao_hora_final")
    private String restricaoHoraFinal;

    @NomeFrontEnd(nome = "Qtde. abajur")
    @Column(name = "qtde_abajur")
    private Integer qtdeAbajur;

    @NomeFrontEnd(nome = "Qtde. armário arquivo")
    @Column(name = "qtde_armario_arquivo")
    private Integer qtdeArmarioArquivo;

    @NomeFrontEnd(nome = "Qtde. armário comum")
    @Column(name = "qtde_armario_comum")
    private Integer qtdeArmarioComum;

    @NomeFrontEnd(nome = "Qtde. aparelho de som")
    @Column(name = "qtde_aparelho_som")
    private Integer qtdeAparelhoSom;

    @NomeFrontEnd(nome = "Qtde. aspirador de pó")
    @Column(name = "qtde_aspirador_po")
    private Integer qtdeAspiradorPo;

    @NomeFrontEnd(nome = "Qtde. ar-condicionado")
    @Column(name = "qtde_ar_condicionado")
    private Integer qtdeArCondicionado;

    @NomeFrontEnd(nome = "Qtde. aquário")
    @Column(name = "qtde_aquario")
    private Integer qtdeAquario;

    @NomeFrontEnd(nome = "Qtde. banco alto")
    @Column(name = "qtde_banco_alto")
    private Integer qtdeBancoAlto;

    @NomeFrontEnd(nome = "Qtde. banco varanda")
    @Column(name = "qtde_banco_varanda")
    private Integer qtdeBancoVaranda;

    @NomeFrontEnd(nome = "Qtde. barzinho")
    @Column(name = "qtde_barzinho")
    private Integer qtdeBarzinho;

    @NomeFrontEnd(nome = "Qtde. baú")
    @Column(name = "qtde_bau")
    private Integer qtdeBau;

    @NomeFrontEnd(nome = "Qtde. berço")
    @Column(name = "qtde_berco")
    private Integer qtdeBerco;

    @NomeFrontEnd(nome = "Qtde. bicicleta")
    @Column(name = "qtde_bicicleta")
    private Integer qtdeBicicleta;

    @NomeFrontEnd(nome = "Qtde. cadeira")
    @Column(name = "qtde_vadeira")
    private Integer qtdeCadeira;

    @NomeFrontEnd(nome = "Qtde. cama solteiro")
    @Column(name = "qtde_cama_solteiro")
    private Integer qtdeCamaSolteiro;

    @NomeFrontEnd(nome = "Qtde. cama casal")
    @Column(name = "qtde_cama_casal")
    private Integer qtdeCamaCasal;

    @NomeFrontEnd(nome = "Qtde. cama beliche")
    @Column(name = "qtde_cama_beliche")
    private Integer qtdeCamaBeliche;

    @NomeFrontEnd(nome = "Qtde. cômoda")
    @Column(name = "qtde_comoda")
    private Integer qtdeComoda;

    @NomeFrontEnd(nome = "Qtde. carrinho de mão")
    @Column(name = "qtde_carrinho_mao")
    private Integer qtdeCarrinhoMao;

    @NomeFrontEnd(nome = "Qtde. churrasqueira")
    @Column(name = "qtde_churrasqueira")
    private Integer qtdeChurrasqueira;

    @NomeFrontEnd(nome = "Qtde. caixas de roupa")
    @Column(name = "qtde_caixa_roupas")
    private Integer qtdeCaixaRoupas;

    @NomeFrontEnd(nome = "Qtde. caixas pequenas")
    @Column(name = "qtde_caixas_pequenas")
    private Integer qtdeCaixasPequenas;

    @NomeFrontEnd(nome = "Qtde. caixas médias")
    @Column(name = "qtde_caixas_medias")
    private Integer qtdeCaixasMedias;

    @NomeFrontEnd(nome = "Qtde. caixas grandes")
    @Column(name = "qtde_caixas_grandes")
    private Integer qtdeCaixasGrandes;

    @NomeFrontEnd(nome = "Qtde. cristaleira")
    @Column(name = "qtde_cristaleira")
    private Integer qtdeCristaleira;

    @NomeFrontEnd(nome = "Qtde. estante")
    @Column(name = "qtde_estante")
    private Integer qtdeEstante;

    @NomeFrontEnd(nome = "Qtde. escrivaninha")
    @Column(name = "qtde_escrivaninha")
    private Integer qtdeEscrivaninha;

    @NomeFrontEnd(nome = "Qtde. espelho")
    @Column(name = "qtde_espelho")
    private Integer qtdeEspelho;

    @NomeFrontEnd(nome = "Qtde. fogão")
    @Column(name = "qtde_fogao")
    private Integer qtdeFogao;

    @NomeFrontEnd(nome = "Qtde. frigobar")
    @Column(name = "qtde_frigobar")
    private Integer qtdeFrigobar;

    @NomeFrontEnd(nome = "Qtde. freezer")
    @Column(name = "qtde_freezer")
    private Integer qtdeFreezer;

    @NomeFrontEnd(nome = "Qtde. guarda-roupa")
    @Column(name = "qtde_guarda_roupa")
    private Integer qtdeGuardaRoupa;

    @NomeFrontEnd(nome = "Qtde. guarda-sol")
    @Column(name = "qtde_guarda_sol")
    private Integer qtdeGuardaSol;

    @NomeFrontEnd(nome = "Qtde. instrumento musical")
    @Column(name = "qtde_instrumento_musical")
    private Integer qtdeInstrumentoMusical;

    @NomeFrontEnd(nome = "Qtde. Luminária")
    @Column(name = "qtde_luminaria")
    private Integer qtdeLuminaria;

    @NomeFrontEnd(nome = "Qtde. Lixeira")
    @Column(name = "qtde_lixeira")
    private Integer qtdeLixeira;

    @NomeFrontEnd(nome = "Qtde. Lava Louças")
    @Column(name = "qtde_lava_loucas")
    private Integer qtdeLavaLoucas;

    @NomeFrontEnd(nome = "Qtde. Lava Roupas")
    @Column(name = "qtde_lava_roupas")
    private Integer qtdeLavaRoupas;

    @NomeFrontEnd(nome = "Qtde. Mesa de Madeira")
    @Column(name = "qtde_mesa_madeira")
    private Integer qtdeMesaMadeira;

    @NomeFrontEnd(nome = "Qtde. Mesa de Vidro")
    @Column(name = "qtde_mesa_vidro")
    private Integer qtdeMesaVidro;

    @NomeFrontEnd(nome = "Qtde. Mesa de Centro")
    @Column(name = "qtde_mesa_centro")
    private Integer qtdeMesaCentro;

    @NomeFrontEnd(nome = "Qtde. Microondas")
    @Column(name = "qtde_microondas")
    private Integer qtdeMicroondas;

    @NomeFrontEnd(nome = "Qtde. Piano")
    @Column(name = "qtde_piano")
    private Integer qtdePiano;

    @NomeFrontEnd(nome = "Qtde. Poltrona")
    @Column(name = "qtde_poltrona")
    private Integer qtdePoltrona;

    @NomeFrontEnd(nome = "Qtde. Prateleira")
    @Column(name = "qtde_prateleira")
    private Integer qtdePrateleira;

    @NomeFrontEnd(nome = "Qtde. Penteadeira")
    @Column(name = "qtde_penteadeira")
    private Integer qtdePenteadeira;

    @NomeFrontEnd(nome = "Qtde. Rack")
    @Column(name = "qtde_rack")
    private Integer qtdeRack;

    @NomeFrontEnd(nome = "Qtde. Refrigerador")
    @Column(name = "qtde_refrigerador")
    private Integer qtdeRefrigerador;

    @NomeFrontEnd(nome = "Qtde. Sofá")
    @Column(name = "qtde_sofa")
    private Integer qtdeSofa;

    @NomeFrontEnd(nome = "Qtde. Secador de Roupas")
    @Column(name = "qtde_secadora_roupas")
    private Integer qtdeSecadoraRoupas;

    @NomeFrontEnd(nome = "Qtde. Televisão")
    @Column(name = "qtde_televisao")
    private Integer qtdeTelevisao;

    @NomeFrontEnd(nome = "Qtde. Tábua de Passar")
    @Column(name = "qtde_tabua_passar")
    private Integer qtdeTabuaPassar;

    @NomeFrontEnd(nome = "Qtde. Outros Itens")
    @Column(name = "outros_itens")
    private String outrosItens;

    protected AnuncioItemMudancaResidencial() {
    }

    public AnuncioItemMudancaResidencial(Anuncio anuncio, List<String> foto, String observacao, Integer qtdeDormitorios, String restricaoHoraInicial, String restricaoHoraFinal, Integer qtdeAbajur, Integer qtdeArmarioArquivo, Integer qtdeArmarioComum, Integer qtdeAparelhoSom, Integer qtdeAspiradorPo, Integer qtdeArCondicionado, Integer qtdeAquario, Integer qtdeBancoAlto, Integer qtdeBancoVaranda, Integer qtdeBarzinho, Integer qtdeBau, Integer qtdeBerco, Integer qtdeBicicleta, Integer qtdeCadeira, Integer qtdeCamaSolteiro, Integer qtdeCamaCasal, Integer qtdeCamaBeliche, Integer qtdeComoda, Integer qtdeCarrinhoMao, Integer qtdeChurrasqueira, Integer qtdeCaixaRoupas, Integer qtdeCaixasPequenas, Integer qtdeCaixasMedias, Integer qtdeCaixasGrandes, Integer qtdeCristaleira, Integer qtdeEstante, Integer qtdeEscrivaninha, Integer qtdeEspelho, Integer qtdeFogao, Integer qtdeFrigobar, Integer qtdeFreezer, Integer qtdeGuardaRoupa, Integer qtdeGuardaSol, Integer qtdeInstrumentoMusical, Integer qtdeLuminaria, Integer qtdeLixeira, Integer qtdeLavaLoucas, Integer qtdeLavaRoupas, Integer qtdeMesaMadeira, Integer qtdeMesaVidro, Integer qtdeMesaCentro, Integer qtdeMicroondas, Integer qtdePiano, Integer qtdePoltrona, Integer qtdePrateleira, Integer qtdePenteadeira, Integer qtdeRack, Integer qtdeRefrigerador, Integer qtdeSofa, Integer qtdeSecadoraRoupas, Integer qtdeTelevisao, Integer qtdeTabuaPassar, String outrosItens) {
        super(anuncio, foto, observacao);
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
