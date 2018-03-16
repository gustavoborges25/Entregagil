package com.time06.escoladeti.anuncio_log;

import com.time06.escoladeti.anuncio.AnuncioService;
import com.time06.escoladeti.anuncio_log.command_event.InserirLogCommand;
import com.time06.escoladeti.anuncio_log.entity.AnuncioLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnuncioLogService {

    @Autowired
    private AnuncioLogRepository repository;

    @Autowired
    private AnuncioService anuncioService;

    public String inserirLog(InserirLogCommand command) {
        AnuncioLog anuncioLog = new AnuncioLog(
                anuncioService.pesquisar(command.getIdAnuncio()),
                new Date(),
                command.getStatus(),
                command.getLocal()
        );
        return repository.save(anuncioLog).getId();
    }

    public AnuncioLog recuperarLog(String id) {
        return repository.findOne(id);
    }

    public List<AnuncioLog> recuperarLogs(String idAnuncio) {
        return repository.findByAnuncioId(idAnuncio);
    }

}
