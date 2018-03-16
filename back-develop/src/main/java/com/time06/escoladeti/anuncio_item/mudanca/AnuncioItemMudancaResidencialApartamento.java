package com.time06.escoladeti.anuncio_item.mudanca;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.NomeFrontEnd;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class AnuncioItemMudancaResidencialApartamento extends AnuncioItemMudancaResidencial {

    @NomeFrontEnd(nome = "Número do Andar")
    private Integer numeroDoAndar;

    protected AnuncioItemMudancaResidencialApartamento() {
    }

    public AnuncioItemMudancaResidencialApartamento(Anuncio anuncio, List<String> foto, String observacao, Integer qtdeDormitorios, String restricaoHoraInicial, String restricaoHoraFinal, Integer qtdeAbajur, Integer qtdeArmarioArquivo, Integer qtdeArmarioComum, Integer qtdeAparelhoSom, Integer qtdeAspiradorPo, Integer qtdeArCondicionado, Integer qtdeAquario, Integer qtdeBancoAlto, Integer qtdeBancoVaranda, Integer qtdeBarzinho, Integer qtdeBau, Integer qtdeBerco, Integer qtdeBicicleta, Integer qtdeCadeira, Integer qtdeCamaSolteiro, Integer qtdeCamaCasal, Integer qtdeCamaBeliche, Integer qtdeComoda, Integer qtdeCarrinhoMao, Integer qtdeChurrasqueira, Integer qtdeCaixaRoupas, Integer qtdeCaixasPequenas, Integer qtdeCaixasMedias, Integer qtdeCaixasGrandes, Integer qtdeCristaleira, Integer qtdeEstante, Integer qtdeEscrivaninha, Integer qtdeEspelho, Integer qtdeFogao, Integer qtdeFrigobar, Integer qtdeFreezer, Integer qtdeGuardaRoupa, Integer qtdeGuardaSol, Integer qtdeInstrumentoMusical, Integer qtdeLuminaria, Integer qtdeLixeira, Integer qtdeLavaLoucas, Integer qtdeLavaRoupas, Integer qtdeMesaMadeira, Integer qtdeMesaVidro, Integer qtdeMesaCentro, Integer qtdeMicroondas, Integer qtdePiano, Integer qtdePoltrona, Integer qtdePrateleira, Integer qtdePenteadeira, Integer qtdeRack, Integer qtdeRefrigerador, Integer qtdeSofa, Integer qtdeSecadoraRoupas, Integer qtdeTelevisao, Integer qtdeTabuaPassar, String outrosItens, Integer numeroDoAndar) {
        super(anuncio, foto, observacao, qtdeDormitorios, restricaoHoraInicial, restricaoHoraFinal, qtdeAbajur, qtdeArmarioArquivo, qtdeArmarioComum, qtdeAparelhoSom, qtdeAspiradorPo, qtdeArCondicionado, qtdeAquario, qtdeBancoAlto, qtdeBancoVaranda, qtdeBarzinho, qtdeBau, qtdeBerco, qtdeBicicleta, qtdeCadeira, qtdeCamaSolteiro, qtdeCamaCasal, qtdeCamaBeliche, qtdeComoda, qtdeCarrinhoMao, qtdeChurrasqueira, qtdeCaixaRoupas, qtdeCaixasPequenas, qtdeCaixasMedias, qtdeCaixasGrandes, qtdeCristaleira, qtdeEstante, qtdeEscrivaninha, qtdeEspelho, qtdeFogao, qtdeFrigobar, qtdeFreezer, qtdeGuardaRoupa, qtdeGuardaSol, qtdeInstrumentoMusical, qtdeLuminaria, qtdeLixeira, qtdeLavaLoucas, qtdeLavaRoupas, qtdeMesaMadeira, qtdeMesaVidro, qtdeMesaCentro, qtdeMicroondas, qtdePiano, qtdePoltrona, qtdePrateleira, qtdePenteadeira, qtdeRack, qtdeRefrigerador, qtdeSofa, qtdeSecadoraRoupas, qtdeTelevisao, qtdeTabuaPassar, outrosItens);
        this.numeroDoAndar = numeroDoAndar;
    }

    public Integer getNumeroDoAndar() {
        return numeroDoAndar;
    }

}
