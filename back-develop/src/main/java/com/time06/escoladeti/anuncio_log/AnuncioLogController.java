package com.time06.escoladeti.anuncio_log;

import com.time06.escoladeti.anuncio_log.command_event.InserirLogCommand;
import com.time06.escoladeti.anuncio_log.entity.AnuncioLog;
import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;

@RestController
@RequestMapping("/anuncio-log")
@CrossOrigin(origins = "*")
public class AnuncioLogController {

    @Autowired
    private AnuncioLogService service;

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST)
    public void inserirLog(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody InserirLogCommand command) {
        service.inserirLog(command);
    };

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AnuncioLog recuperarLog(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.recuperarLog(id);
    };

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/anuncio/{idAnuncio}")
    public List<AnuncioLog> recuperarLogs(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idAnuncio") String idAnuncio) {
        return service.recuperarLogs(idAnuncio);
    };

}
