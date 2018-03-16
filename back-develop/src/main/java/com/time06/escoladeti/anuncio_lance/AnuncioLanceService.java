package com.time06.escoladeti.anuncio_lance;

import com.time06.escoladeti.anuncio.AnuncioService;
import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_lance.command_event.AceitarLanceCommand;
import com.time06.escoladeti.anuncio_lance.command_event.CancelarLanceCommand;
import com.time06.escoladeti.anuncio_lance.command_event.DarLanceCommand;
import com.time06.escoladeti.anuncio_lance.entity.AnuncioLance;
import com.time06.escoladeti.anuncio_lance.entity.AnuncioLanceAceitarException;
import com.time06.escoladeti.anuncio_lance.entity.AnuncioLanceStatus;
import com.time06.escoladeti.infraestrutura.notificacao.EnviarNotificacaoLanceRecebidoEvent;
import com.time06.escoladeti.infraestrutura.notificacao.EnviarNotificacaoLanceRecebidoService;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa.PessoaService;
import com.time06.escoladeti.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AnuncioLanceService {

    @Autowired
    private AnuncioLanceRepository repository;

    @Autowired
    private AnuncioService anuncioService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnviarNotificacaoLanceRecebidoService notificacaoLanceRecebidoService;

    @Transactional
    public AnuncioLance getLance(String id) {
        return repository.findOne(id);
    }

    @Transactional
    public List<AnuncioLance> getLancesDoAnuncio(String idAnuncio) {
        return repository.findByAnuncioId(idAnuncio);
    }

    public void novoLance(DarLanceCommand command) {

    	Anuncio anuncio = anuncioService.pesquisar(command.getIdAnuncio());

    	Pessoa pessoa = pessoaService.findOne(command.getIdTransportador());

    	           repository.save(
    	                   new AnuncioLance(
    	                                  anuncio,
    	                                  pessoa,
    	                                   command.getEstimativa(),
    	                                   command.getValor(),
    	                                   command.getCargaFracionada(),
    	                                   command.getObservacoes()
    	                   )
    	           );

    	notificacaoLanceRecebidoService.enviaEmailLanceRecebido(new EnviarNotificacaoLanceRecebidoEvent(anuncio.getId(),
    	                  anuncio.getTitulo(), pessoa.getNome(), pessoa.getUsuario().get(0).getEmail()));


    }

    @Transactional
    public void aceitarLance(String id) {
        Long lanceCancelado = repository.lanceComStatus(id, AnuncioLanceStatus.CANCELADO);
        if (lanceCancelado > 0) {
            throw new AnuncioLanceAceitarException();
        }

        repository.updateStatusLance(id, AnuncioLanceStatus.ACEITO);
    }

    @Transactional
    public void cancelarLance(String id) {
        repository.updateStatusLance(id, AnuncioLanceStatus.CANCELADO);
    }

    @Transactional
    public void aceitarLance(AceitarLanceCommand command) {
        AnuncioLance lance = repository.findOne(command.getIdLance());
        lance.aceitar(command.getIdPessoa());
        repository.save(lance);
        anuncioService.defineTransportador(lance.getAnuncio(), pessoaService.findOne(command.getIdPessoa()));
    }

    public void cancelarLance(CancelarLanceCommand command) {
        AnuncioLance lance = repository.findOne(command.getIdLance());
        lance.cancelar(command.getIdPessoa());
        repository.save(lance);
    }

    @Transactional
    public AnuncioLance getMenorLanceDoAnuncio(String idAnuncio) {
        AnuncioLance lance = repository.findTop1ByAnuncioIdOrderByValorAsc(idAnuncio);
        if (lance == null) {
            return null;
        }
        return lance.removeAnuncio(); // não precisa retornar anúncio neste caso
    }

    @Transactional
    public List<AnuncioLance> anunciosQueDeiLance(String idPessoaLogada) {
        return repository.findByTransportadorId(idPessoaLogada);
    }

}
