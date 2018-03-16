package com.time06.escoladeti.anuncio_pergunta;

import com.time06.escoladeti.anuncio_pergunta.command_event.PerguntarCommand;
import com.time06.escoladeti.anuncio_pergunta.command_event.ResponderCommand;
import com.time06.escoladeti.anuncio_pergunta.entity.AnuncioPergunta;
import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;

@RestController
@RequestMapping("/anuncio-pergunta")
@CrossOrigin(origins = "*")
public class AnuncioPerguntaController {

    @Autowired
    private AnuncioPerguntaService service;

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/anuncio/{idAnuncio}")
    public List<AnuncioPergunta> getPerguntasDoAnuncio(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String idAnuncio) {
        return service.getPerguntasDoAnuncio(idAnuncio);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/perguntar")
    public List<AnuncioPergunta> perguntar(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody PerguntarCommand command) {
        service.perguntar(command);
        return service.getPerguntasDoAnuncio(command.getIdAnuncio());
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/responder")
    public void responder(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody ResponderCommand command) {
        service.responder(command);
    }

}