package com.time06.escoladeti.anuncio;

import com.time06.escoladeti.anuncio.command.CriarAnuncioCommand;
import com.time06.escoladeti.anuncio.command.carga.*;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioAnimalCommand;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioDomesticoCommand;
import com.time06.escoladeti.anuncio.command.domestico.CriarAnuncioTelefoniaCommand;
import com.time06.escoladeti.anuncio.command.mudanca.*;
import com.time06.escoladeti.anuncio.command.outro.CriarAnuncioOutroCommand;
import com.time06.escoladeti.anuncio.command.veiculo.*;
import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio.entity.AnuncioSituacao;
import com.time06.escoladeti.anuncio.type.TipoCategoria;
import com.time06.escoladeti.anuncio.type.TipoSubcategoria;
import com.time06.escoladeti.anuncio_item.AnuncioItemService;
import com.time06.escoladeti.anuncio_log.AnuncioLogService;
import com.time06.escoladeti.anuncio_log.command_event.InserirLogCommand;
import com.time06.escoladeti.anuncio_log.entity.AnuncioLogStatus;
import com.time06.escoladeti.endereco.CriarEnderecoEvent;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.infraestrutura.Util;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private AnuncioItemService anuncioItemService;

    @Autowired
    private AnuncioLogService anuncioLogService;

    @Transactional
    public void criarAnuncioCarro(CriarAnuncioCarroCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCarro(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMoto(CriarAnuncioMotoCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMoto(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioBarco(CriarAnuncioBarcoCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioBarco(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioCaminhao(CriarAnuncioCaminhaoCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCaminhao(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioAgricola(CriarAnuncioAgricolaCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioAgricola(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioEsporte(CriarAnuncioEsporteCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioEsporte(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioPeca(CriarAnuncioPecaCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.VEICULO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioPeca(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMudancaResidencial(CriarAnuncioMudancaResidencialCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.MUDANCA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMudancaResidencial(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMudancaSobrado(CriarAnuncioMudancaResidencialSobradoCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.MUDANCA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMudancaSobrado(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMudancaApartamento(CriarAnuncioMudancaResidencialApartamentoCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.MUDANCA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMudancaApartamento(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMudancaComercial(CriarAnuncioMudancaComercialCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.MUDANCA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMudancaComercial(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMudancaComercialEscritorio(CriarAnuncioMudancaComercialEscritorioCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.MUDANCA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMudancaComercialEscritorio(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioMudancaComercialIndustrial(CriarAnuncioMudancaComercialIndustrialCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.MUDANCA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioMudancaComercialIndustrial(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioCarga(CriarAnuncioCargaCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.CARGA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCarga(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioCargaFracionada(CriarAnuncioCargaFracionadaCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.CARGA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCargaFracionada(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioCargaCompleta(CriarAnuncioCargaCompletaCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.CARGA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCargaCompleta(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioCargaFragil(CriarAnuncioCargaFragilCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.CARGA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCargaFragil(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioCargaContainer(CriarAnuncioCargaContainerCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.CARGA, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioCargaContainer(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioDomesticoGeral(CriarAnuncioDomesticoCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.DOMESTICO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioDomesticoGeral(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioTelefonia(CriarAnuncioTelefoniaCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.DOMESTICO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioTelefonia(anuncio, command));
        repository.save(anuncio);
    }

    @Transactional
    public void criarAnuncioAnimal(CriarAnuncioAnimalCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.DOMESTICO, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioAnimal(anuncio, command));
        repository.save(anuncio);
    }

    public void criarAnuncioOutro(CriarAnuncioOutroCommand command, TipoSubcategoria subcategoria) {
        Anuncio anuncio = repository.save(criarAnuncio(command, TipoCategoria.OUTROS, subcategoria));
        anuncio.setItem(anuncioItemService.salvarItemAnuncioOutro(anuncio, command));
        repository.save(anuncio);
    }



    private Anuncio criarAnuncio(CriarAnuncioCommand command, TipoCategoria categoria, TipoSubcategoria subcategoria) {
        return new Anuncio(
                command.getTitulo(),
                command.getDataValidade(),
                pessoaService.findOne(command.getIdPessoa()),
                new Endereco(new CriarEnderecoEvent(
                        command.getEnderecoOrigem().getId(),
                        command.getEnderecoOrigem().getCep(),
                        command.getEnderecoOrigem().getEndereco(),
                        command.getEnderecoOrigem().getNumero(),
                        command.getEnderecoOrigem().getBairro(),
                        command.getEnderecoOrigem().getTipoEndereco(),
                        command.getEnderecoOrigem().getComplemento(),
                        command.getEnderecoOrigem().getCidade(),
                        command.getEnderecoOrigem().getEstado())),
                new Endereco(new CriarEnderecoEvent(
                        command.getEnderecoDestino().getId(),
                        command.getEnderecoDestino().getCep(),
                        command.getEnderecoDestino().getEndereco(),
                        command.getEnderecoDestino().getNumero(),
                        command.getEnderecoDestino().getBairro(),
                        command.getEnderecoDestino().getTipoEndereco(),
                        command.getEnderecoDestino().getComplemento(),
                        command.getEnderecoDestino().getCidade(),
                        command.getEnderecoDestino().getEstado())),
                command.getContatoOrigem(),
                command.getTelefoneOrigem(),
                command.getContatoDestino(),
                command.getTelefoneDestino(),
                AnuncioSituacao.RECEBENDO_LANCE,
                categoria,
                subcategoria,
                salvaFotos(command.getFotos()));
    }

    private List<String> salvaFotos(List<String> fotosBase64) {
        List<String> fotosSalvas = new ArrayList<>();
        fotosBase64.forEach(s -> fotosSalvas.add(Util.saveImage(s)));
        return fotosSalvas;
    }

    @Transactional
    public List<Anuncio> pesquisar() {
        return repository.findAll();
    }

    @Transactional
    public List<Anuncio> getUltimosDozeAnuncios() {
        return repository.findTop12ByOrderByDataCadastroDesc();
    }

    @Transactional
    public List<Anuncio> pesquisarAnunciosDaPessoa(String idPessoa) {
        return repository.findByAnuncianteIdAndSituacaoNot(idPessoa, AnuncioSituacao.CANCELADO);
    }

    @Transactional
    public List<Anuncio> pesquisarAnunciosQuePessoaTransporta(String idPessoa) {
        return repository.findByTransportadorIdAndSituacaoNot(idPessoa, AnuncioSituacao.CANCELADO);
    }

    @Transactional
    public Anuncio pesquisar(String id) {
        return repository.findOne(id);
    }

    @Transactional
    public List<Anuncio> pesquisarAnunciosComItensDestaCategoria(String nomeCategoria) {
        repository.normalizaDadosParaPesquisa();
        return repository.findByCategoria(TipoCategoria.porString(nomeCategoria));
    }

    @Transactional
    public List<Anuncio> pesquisarAnunciosPorQuery(String query) {
        repository.normalizaDadosParaPesquisa();
        return repository.pesquisarAnunciosPorQuery(query);
    }

    public Integer getQuantidadeAnunciosCadastradosPeloAnunciante(String idAnunciante) {
        return repository.getQuantidadeAnunciosCadastradosPeloAnunciante(idAnunciante);
    }

    public Integer getQuantidadeAnunciosTransportadosPeloTransportador(String idTransportador) {
        return 0; // TODO : ainda não há relação entre transportador e anúncio
    }

    public void cancelarAnuncio(String idAnuncio) {
        Anuncio anuncio = repository.findOne(idAnuncio);
        anuncio.cancelar();
        repository.save(anuncio);
    }

    @Transactional
    public void cancelarTransporte(String idAnuncio) {
        Anuncio anuncio = repository.findOne(idAnuncio);
        anuncio.cancelarTransporte();
        repository.save(anuncio);
        anuncioLogService.inserirLog(new InserirLogCommand(anuncio.getId(), AnuncioLogStatus.CANCELADO, null));
        anuncioLogService.inserirLog(new InserirLogCommand(anuncio.getId(), AnuncioLogStatus.AGUARDANDO_LANCE, null));
    }

    public void defineTransportador(Anuncio anuncio, Pessoa transportador) {
        anuncio.definirTransportador(transportador);
    }

}