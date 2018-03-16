package com.time06.escoladeti.anuncio_pergunta;

import com.time06.escoladeti.anuncio.AnuncioService;
import com.time06.escoladeti.anuncio_pergunta.command_event.PerguntarCommand;
import com.time06.escoladeti.anuncio_pergunta.command_event.ResponderCommand;
import com.time06.escoladeti.anuncio_pergunta.entity.AnuncioPergunta;
import com.time06.escoladeti.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnuncioPerguntaService {

    @Autowired
    private AnuncioPerguntaRepository repository;

    @Autowired
    private AnuncioService anuncioService;

    @Autowired
    private PessoaService pessoaService;

    @Transactional
    public List<AnuncioPergunta> getPerguntasDoAnuncio(String idAnuncio) {
        return repository.findByAnuncioIdOrderByDataCadastroDesc(idAnuncio);
    }

    public void perguntar(PerguntarCommand command) {
        AnuncioPergunta pergunta = new AnuncioPergunta(
                anuncioService.pesquisar(command.getIdAnuncio()),
                pessoaService.findOne(command.getIdPessoa()),
                command.getConteudo());
        repository.save(pergunta);
    }

    public void responder(ResponderCommand command) {
        AnuncioPergunta resposta = new AnuncioPergunta(
                repository.findOne(command.getIdPergunta()),
                pessoaService.findOne(command.getIdPessoa()),
                command.getConteudo());
        repository.save(resposta);
    }

}