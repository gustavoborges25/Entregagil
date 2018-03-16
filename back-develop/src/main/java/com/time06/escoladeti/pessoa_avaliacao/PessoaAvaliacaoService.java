package com.time06.escoladeti.pessoa_avaliacao;

import com.time06.escoladeti.anuncio.AnuncioService;
import com.time06.escoladeti.anuncio.entity.AnuncioSituacao;
import com.time06.escoladeti.pessoa.PessoaService;
import com.time06.escoladeti.pessoa_avaliacao.command_event.AvaliarAnuncianteCommand;
import com.time06.escoladeti.pessoa_avaliacao.command_event.AvaliarTransportadorCommand;
import com.time06.escoladeti.pessoa_avaliacao.entity.AvaliadoComo;
import com.time06.escoladeti.pessoa_avaliacao.entity.PessoaAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class PessoaAvaliacaoService {

    @Autowired
    private PessoaAvaliacaoRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private AnuncioService anuncioService;

    public String avaliarAnunciante(AvaliarAnuncianteCommand command) {
        return repository.save(
                new PessoaAvaliacao(pessoaService.findOne(command.getIdAvaliador()),
                                    pessoaService.findOne(command.getIdAnunciante()),
                                    AvaliadoComo.ANUNCIANTE,
                                    command.getAvaliacaoGeral(),
                                    command.getRecomenda(),
                                    command.getComentario())).getId();
    }

    public String avaliarTransportador(AvaliarTransportadorCommand command) {
        return repository.save(
                new PessoaAvaliacao(pessoaService.findOne(command.getIdAvaliador()),
                                    pessoaService.findOne(command.getIdTransportador()),
                                    AvaliadoComo.TRANSPORTADOR,
                                    command.getAvaliacaoGeral(),
                                    command.getRecomenda(),
                                    command.getTempoDeEntrega(),
                                    command.getIntegridadeMercadoria(),
                                    command.getComentario())
        ).getId();
    }

    @Transactional
    public List<PessoaAvaliacao> getAvaliacoesFeitasPor(String idAvaliador) {
        return repository.findByAvaliadorId(idAvaliador);
    }

    @Transactional
    public List<PessoaAvaliacao> getAvaliacoesFeitasParaComoAnunciante(String idAvaliado) {
        return repository.findByAvaliadoIdAndAvaliadoAvaliadoComo(idAvaliado, AvaliadoComo.ANUNCIANTE);
    }

    @Transactional
    public List<PessoaAvaliacao> getAvaliacoesFeitasParaComoTransportador(String idAvaliado) {
        return repository.findByAvaliadoIdAndAvaliadoAvaliadoComo(idAvaliado, AvaliadoComo.TRANSPORTADOR);
    }

    @Transactional
    public PessoaAvaliacao getAvaliacao(String id) {
        return repository.findById(id);
    }

    @Transactional
    public double getMediaTempoEntrega(String id) {
        List<PessoaAvaliacao> avaliacoes = getAvaliacoesFeitasParaComoTransportador(id);
        OptionalDouble mediaTempoEntrega = avaliacoes.stream().mapToDouble(PessoaAvaliacao::getTempoDeEntrega).average();
        return mediaTempoEntrega.isPresent() ? mediaTempoEntrega.getAsDouble() : Double.valueOf(0);
    }

    @Transactional
    public double getMediaIntegridadeMercadoria(String id) {
        List<PessoaAvaliacao> avaliacoes = getAvaliacoesFeitasParaComoTransportador(id);
        OptionalDouble mediaIntegridadeMercadoria = avaliacoes.stream().mapToDouble(PessoaAvaliacao::getIntegridadeMercadoria).average();
        return mediaIntegridadeMercadoria.isPresent() ? mediaIntegridadeMercadoria.getAsDouble() : Double.valueOf(0);
    }

    @Transactional
    public double getMediaEstrelasAnunciante(String id) {
        List<PessoaAvaliacao> avaliacoes = getAvaliacoesFeitasParaComoAnunciante(id);
        OptionalDouble media = avaliacoes.stream()
                                                    .filter(pessoaAvaliacao -> AvaliadoComo.ANUNCIANTE.equals(pessoaAvaliacao.getAvaliadoAvaliadoComo()))
                                                    .mapToDouble(PessoaAvaliacao::getAvaliacaoGeral).average();
        return media.isPresent() ? media.getAsDouble() : Double.valueOf(0);
    }

    @Transactional
    public double getMediaEstrelasTransportador(String id) {
        List<PessoaAvaliacao> avaliacoes = getAvaliacoesFeitasParaComoTransportador(id);
        OptionalDouble media = avaliacoes.stream()
                                                    .filter(pessoaAvaliacao -> AvaliadoComo.TRANSPORTADOR.equals(pessoaAvaliacao.getAvaliadoAvaliadoComo()))
                                                    .mapToDouble(PessoaAvaliacao::getAvaliacaoGeral).average();
        return media.isPresent() ? media.getAsDouble() : Double.valueOf(0);
    }

    @Transactional
    public double getPercentualRecomendacoesTransportador(String id) {
        List<PessoaAvaliacao> avaliacoes = getAvaliacoesFeitasParaComoTransportador(id);
        if (avaliacoes.size() == 0) {
            return 0;
        }

        long qtde = avaliacoes.stream()
                .filter(pessoaAvaliacao -> AvaliadoComo.TRANSPORTADOR.equals(pessoaAvaliacao.getAvaliadoAvaliadoComo()) && pessoaAvaliacao.getRecomenda())
                .count();
        return (qtde * 100) / avaliacoes.size();
    }

    @Transactional
    public long getQtdeTransportesFinalizados(String id) {
        return anuncioService.pesquisarAnunciosQuePessoaTransporta(id)
                .stream()
                .filter(anuncio -> AnuncioSituacao.FINALIZADO.equals(anuncio.getSituacao()))
                .count();
    }

}