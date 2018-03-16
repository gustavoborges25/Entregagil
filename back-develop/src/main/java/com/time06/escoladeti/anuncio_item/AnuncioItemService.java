package com.time06.escoladeti.anuncio_item;

import com.time06.escoladeti.anuncio.command.carga.*;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioAnimalCommand;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioDomesticoCommand;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioTelefoniaCommand;
import com.time06.escoladeti.anuncio.command.mudanca.*;
import com.time06.escoladeti.anuncio.command.outro.CriarAnuncioOutroCommand;
import com.time06.escoladeti.anuncio.command.veiculo.*;
import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_item.carga.*;
import com.time06.escoladeti.anuncio_item.domestico.AnuncioItemAnimal;
import com.time06.escoladeti.anuncio_item.domestico.AnuncioItemDomesticoGeral;
import com.time06.escoladeti.anuncio_item.domestico.AnuncioItemTelefonia;
import com.time06.escoladeti.anuncio_item.mudanca.*;
import com.time06.escoladeti.anuncio_item.outro.AnuncioItemOutro;
import com.time06.escoladeti.anuncio_item.veiculo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioItemService {

    @Autowired
    private AnuncioItemRepository repository;

    public AnuncioItem salvarItemAnuncioCarro(Anuncio anuncio, CriarAnuncioCarroCommand command) {
        return repository.save(new AnuncioItemCarro(anuncio, null, command.getObservacao(), command.getMarca(), command.getModelo(), command.getTipoTransporte(), command.getTipoTransporteGuinchoCegonha()));
    }

    public AnuncioItem salvarItemAnuncioMoto(Anuncio anuncio, CriarAnuncioMotoCommand command) {
        return repository.save(new AnuncioItemMoto(anuncio, null, command.getObservacao(), command.getMarca(), command.getModelo(), command.getTipoMoto(), command.getTipoTransporte(), command.getTipoTransporteGuinchoCegonha()));
    }

    public AnuncioItem salvarItemAnuncioBarco(Anuncio anuncio, CriarAnuncioBarcoCommand command) {
        return repository.save(new AnuncioItemBarco(anuncio, null, command.getObservacao(), command.getMarca(), command.getModelo(), command.getLargura(), command.getAltura(), command.getComprimento(), command.getPeso(), command.getNoReboque(),  command.getTipoBarco()));
    }

    public AnuncioItem salvarItemAnuncioCaminhao(Anuncio anuncio, CriarAnuncioCaminhaoCommand command) {
        return repository.save(new AnuncioItemCaminhao(anuncio, null, command.getObservacao(), command.getMarca(), command.getModelo(), command.getNoReboque(), command.getTipoCaminhao()));
    }

    public AnuncioItem salvarItemAnuncioAgricola(Anuncio anuncio, CriarAnuncioAgricolaCommand command) {
        return repository.save(new AnuncioItemAgricola(anuncio, null, command.getObservacao(), command.getEspecificacaoVeiculo(), command.getMarca(), command.getModelo(), command.getNoReboque(), command.getTipoAgricola()));
    }


    public AnuncioItem salvarItemAnuncioEsporte(Anuncio anuncio, CriarAnuncioEsporteCommand command) {
        return repository.save(new AnuncioItemEsporte(anuncio, null, command.getObservacao(), command.getTipo(), command.getLargura(), command.getAltura(), command.getComprimento(), command.getPeso()));
    }

    public AnuncioItem salvarItemAnuncioPeca(Anuncio anuncio, CriarAnuncioPecaCommand command) {
        return repository.save(new AnuncioItemPeca(anuncio, null, command.getObservacao(), command.getTipo(), command.getEmbalagem(), command.getLargura(), command.getAltura(), command.getComprimento(), command.getPeso()));
    }

    public AnuncioItem salvarItemAnuncioMudancaResidencial(Anuncio anuncio, CriarAnuncioMudancaResidencialCommand command) {
        return repository.save(new AnuncioItemMudancaResidencial(
                        anuncio,
                        null,
                        command.getObservacao(),
                        command.getQtdeDormitorios(),
                        command.getRestricaoHoraInicial(),
                        command.getRestricaoHoraFinal(),
                        command.getQtdeAbajur(),
                        command.getQtdeArmarioArquivo(),
                        command.getQtdeArmarioComum(),
                        command.getQtdeAparelhoSom(),
                        command.getQtdeAspiradorPo(),
                        command.getQtdeArCondicionado(),
                        command.getQtdeAquario(),
                        command.getQtdeBancoAlto(),
                        command.getQtdeBancoVaranda(),
                        command.getQtdeBarzinho(),
                        command.getQtdeBau(),
                        command.getQtdeBerco(),
                        command.getQtdeBicicleta(),
                        command.getQtdeCadeira(),
                        command.getQtdeCamaSolteiro(),
                        command.getQtdeCamaCasal(),
                        command.getQtdeCamaBeliche(),
                        command.getQtdeComoda(),
                        command.getQtdeCarrinhoMao(),
                        command.getQtdeChurrasqueira(),
                        command.getQtdeCaixaRoupas(),
                        command.getQtdeCaixasPequenas(),
                        command.getQtdeCaixasMedias(),
                        command.getQtdeCaixasGrandes(),
                        command.getQtdeCristaleira(),
                        command.getQtdeEstante(),
                        command.getQtdeEscrivaninha(),
                        command.getQtdeEspelho(),
                        command.getQtdeFogao(),
                        command.getQtdeFrigobar(),
                        command.getQtdeFreezer(),
                        command.getQtdeGuardaRoupa(),
                        command.getQtdeGuardaSol(),
                        command.getQtdeInstrumentoMusical(),
                        command.getQtdeLuminaria(),
                        command.getQtdeLixeira(),
                        command.getQtdeLavaLoucas(),
                        command.getQtdeLavaRoupas(),
                        command.getQtdeMesaMadeira(),
                        command.getQtdeMesaVidro(),
                        command.getQtdeMesaCentro(),
                        command.getQtdeMicroondas(),
                        command.getQtdePiano(),
                        command.getQtdePoltrona(),
                        command.getQtdePrateleira(),
                        command.getQtdePenteadeira(),
                        command.getQtdeRack(),
                        command.getQtdeRefrigerador(),
                        command.getQtdeSofa(),
                        command.getQtdeSecadoraRoupas(),
                        command.getQtdeTelevisao(),
                        command.getQtdeTabuaPassar(),
                        command.getOutrosItens())
        );
    }

    public AnuncioItem salvarItemAnuncioMudancaSobrado(Anuncio anuncio, CriarAnuncioMudancaResidencialSobradoCommand command) {
        return repository.save(new AnuncioItemMudancaResidencialSobrado(
                anuncio,
                null,
                command.getObservacao(),
                command.getQtdeDormitorios(),
                command.getRestricaoHoraInicial(),
                command.getRestricaoHoraFinal(),
                command.getQtdeAbajur(),
                command.getQtdeArmarioArquivo(),
                command.getQtdeArmarioComum(),
                command.getQtdeAparelhoSom(),
                command.getQtdeAspiradorPo(),
                command.getQtdeArCondicionado(),
                command.getQtdeAquario(),
                command.getQtdeBancoAlto(),
                command.getQtdeBancoVaranda(),
                command.getQtdeBarzinho(),
                command.getQtdeBau(),
                command.getQtdeBerco(),
                command.getQtdeBicicleta(),
                command.getQtdeCadeira(),
                command.getQtdeCamaSolteiro(),
                command.getQtdeCamaCasal(),
                command.getQtdeCamaBeliche(),
                command.getQtdeComoda(),
                command.getQtdeCarrinhoMao(),
                command.getQtdeChurrasqueira(),
                command.getQtdeCaixaRoupas(),
                command.getQtdeCaixasPequenas(),
                command.getQtdeCaixasMedias(),
                command.getQtdeCaixasGrandes(),
                command.getQtdeCristaleira(),
                command.getQtdeEstante(),
                command.getQtdeEscrivaninha(),
                command.getQtdeEspelho(),
                command.getQtdeFogao(),
                command.getQtdeFrigobar(),
                command.getQtdeFreezer(),
                command.getQtdeGuardaRoupa(),
                command.getQtdeGuardaSol(),
                command.getQtdeInstrumentoMusical(),
                command.getQtdeLuminaria(),
                command.getQtdeLixeira(),
                command.getQtdeLavaLoucas(),
                command.getQtdeLavaRoupas(),
                command.getQtdeMesaMadeira(),
                command.getQtdeMesaVidro(),
                command.getQtdeMesaCentro(),
                command.getQtdeMicroondas(),
                command.getQtdePiano(),
                command.getQtdePoltrona(),
                command.getQtdePrateleira(),
                command.getQtdePenteadeira(),
                command.getQtdeRack(),
                command.getQtdeRefrigerador(),
                command.getQtdeSofa(),
                command.getQtdeSecadoraRoupas(),
                command.getQtdeTelevisao(),
                command.getQtdeTabuaPassar(),
                command.getOutrosItens(),
                command.getQtdeAndares())
        );
    }

    public AnuncioItem salvarItemAnuncioMudancaApartamento(Anuncio anuncio, CriarAnuncioMudancaResidencialApartamentoCommand command) {
        return repository.save(new AnuncioItemMudancaResidencialApartamento(
                anuncio,
                null,
                command.getObservacao(),
                command.getQtdeDormitorios(),
                command.getRestricaoHoraInicial(),
                command.getRestricaoHoraFinal(),
                command.getQtdeAbajur(),
                command.getQtdeArmarioArquivo(),
                command.getQtdeArmarioComum(),
                command.getQtdeAparelhoSom(),
                command.getQtdeAspiradorPo(),
                command.getQtdeArCondicionado(),
                command.getQtdeAquario(),
                command.getQtdeBancoAlto(),
                command.getQtdeBancoVaranda(),
                command.getQtdeBarzinho(),
                command.getQtdeBau(),
                command.getQtdeBerco(),
                command.getQtdeBicicleta(),
                command.getQtdeCadeira(),
                command.getQtdeCamaSolteiro(),
                command.getQtdeCamaCasal(),
                command.getQtdeCamaBeliche(),
                command.getQtdeComoda(),
                command.getQtdeCarrinhoMao(),
                command.getQtdeChurrasqueira(),
                command.getQtdeCaixaRoupas(),
                command.getQtdeCaixasPequenas(),
                command.getQtdeCaixasMedias(),
                command.getQtdeCaixasGrandes(),
                command.getQtdeCristaleira(),
                command.getQtdeEstante(),
                command.getQtdeEscrivaninha(),
                command.getQtdeEspelho(),
                command.getQtdeFogao(),
                command.getQtdeFrigobar(),
                command.getQtdeFreezer(),
                command.getQtdeGuardaRoupa(),
                command.getQtdeGuardaSol(),
                command.getQtdeInstrumentoMusical(),
                command.getQtdeLuminaria(),
                command.getQtdeLixeira(),
                command.getQtdeLavaLoucas(),
                command.getQtdeLavaRoupas(),
                command.getQtdeMesaMadeira(),
                command.getQtdeMesaVidro(),
                command.getQtdeMesaCentro(),
                command.getQtdeMicroondas(),
                command.getQtdePiano(),
                command.getQtdePoltrona(),
                command.getQtdePrateleira(),
                command.getQtdePenteadeira(),
                command.getQtdeRack(),
                command.getQtdeRefrigerador(),
                command.getQtdeSofa(),
                command.getQtdeSecadoraRoupas(),
                command.getQtdeTelevisao(),
                command.getQtdeTabuaPassar(),
                command.getOutrosItens(),
                command.getNumeroDoAndar())
        );
    }

    public AnuncioItem salvarItemAnuncioMudancaComercial(Anuncio anuncio, CriarAnuncioMudancaComercialCommand command) {
        return repository.save(new AnuncioItemMudancaComercial(anuncio, null, command.getObservacao(), command.getRestricaoHorarioInicial(), command.getRestricaoHorarioFinal(), command.getQtdeItens(), command.getItens()));
    }

    public AnuncioItem salvarItemAnuncioMudancaComercialEscritorio(Anuncio anuncio, CriarAnuncioMudancaComercialEscritorioCommand command) {
        return repository.save(new AnuncioItemMudancaComercialEscritorio(anuncio, null, command.getObservacao(), command.getRestricaoHorarioInicial(), command.getRestricaoHorarioFinal(), command.getQtdeItens(), command.getItens(), command.getTerreoPredio()));
    }

    public AnuncioItem salvarItemAnuncioMudancaComercialIndustrial(Anuncio anuncio, CriarAnuncioMudancaComercialIndustrialCommand command) {
        return repository.save(new AnuncioItemMudancaComercialIndustrial(anuncio, null, command.getObservacao(), command.getRestricaoHorarioInicial(), command.getRestricaoHorarioFinal(), command.getQtdeItens(), command.getItens(), command.getTamanho()));
    }

    public AnuncioItem salvarItemAnuncioCarga(Anuncio anuncio, CriarAnuncioCargaCommand command) {
        return repository.save(new AnuncioItemCarga(anuncio, null, command.getObservacao(), command.getTipo(), command.getPeso()));
    }

    public AnuncioItem salvarItemAnuncioCargaFracionada(Anuncio anuncio, CriarAnuncioCargaFracionadaCommand command) {
        return repository.save(new AnuncioItemCargaFracionada(anuncio, null, command.getObservacao(), command.getTipo(), command.getPeso(), command.getEmbalagem(), command.getAltura(), command.getLargura(), command.getComprimento()));
    }

    public AnuncioItem salvarItemAnuncioCargaCompleta(Anuncio anuncio, CriarAnuncioCargaCompletaCommand command) {
        return repository.save(new AnuncioItemCargaCompleta(anuncio, null, command.getObservacao(), command.getTipo(), command.getPeso(), command.getEmbalagem(), command.getPrecisaPagarDescarga()));
    }

    public AnuncioItem salvarItemAnuncioCargaFragil(Anuncio anuncio, CriarAnuncioCargaFragilCommand command) {
        return repository.save(new AnuncioItemCargaFragil(anuncio, null, command.getObservacao(), command.getTipo(), command.getPeso(), command.getEmbalagem()));
    }

    public AnuncioItem salvarItemAnuncioCargaContainer(Anuncio anuncio, CriarAnuncioCargaContainerCommand command) {
        return repository.save(new AnuncioItemCargaContainer(anuncio, null, command.getObservacao(), command.getTipo(), command.getPeso(), command.getAltura(), command.getLargura(), command.getComprimento()));
    }

    public AnuncioItem salvarItemAnuncioDomesticoGeral(Anuncio anuncio, CriarAnuncioDomesticoCommand command) {
        return repository.save(new AnuncioItemDomesticoGeral(anuncio, null, command.getObservacao(), command.getTipo(), command.getEmbalagem(), command.getAltura(), command.getLargura(), command.getComprimento(), command.getPeso()));
    }

    public AnuncioItem salvarItemAnuncioTelefonia(Anuncio anuncio, CriarAnuncioTelefoniaCommand command) {
        return repository.save(new AnuncioItemTelefonia(anuncio, null, command.getObservacao(), command.getMarca(), command.getModelo(), command.getEmbalagem(), command.getAltura(), command.getLargura(), command.getComprimento(), command.getPeso()));
    }

    public AnuncioItem salvarItemAnuncioAnimal(Anuncio anuncio, CriarAnuncioAnimalCommand command) {
        return repository.save(new AnuncioItemAnimal(anuncio, null, command.getObservacao(), command.getTipo(), command.getNome(), command.getRaca(), command.getPeso(), command.getAltura(), command.getVacinacaoEmDia(), command.getPossuiTodosRegistros(), command.getPossuiCaixaTranporte()));
    }

    public AnuncioItem salvarItemAnuncioOutro(Anuncio anuncio, CriarAnuncioOutroCommand command) {
            return repository.save(new AnuncioItemOutro(anuncio, null, command.getObservacao(), command.getNomeItem(), command.getAltura(), command.getLargura(), command.getComprimento()));
    }
}