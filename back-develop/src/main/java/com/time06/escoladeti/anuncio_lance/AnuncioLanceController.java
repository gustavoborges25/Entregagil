package com.time06.escoladeti.anuncio_lance;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio_lance.command_event.AceitarLanceCommand;
import com.time06.escoladeti.anuncio_lance.command_event.CancelarLanceCommand;
import com.time06.escoladeti.anuncio_lance.command_event.DarLanceCommand;
import com.time06.escoladeti.anuncio_lance.entity.AnuncioLance;
import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;

@RestController
@RequestMapping("/anuncio-lance")
@CrossOrigin(origins = "*")
public class AnuncioLanceController {

    @Autowired
    AnuncioLanceService service;

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AnuncioLance getLance(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String id) {
        return service.getLance(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/anuncio/{idAnuncio}")
    public List<AnuncioLance> getLancesDoAnuncio(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String idAnuncio) {
        return service.getLancesDoAnuncio(idAnuncio);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public List<AnuncioLance> novoLance(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody DarLanceCommand command) {
        service.novoLance(command);
        return service.getLancesDoAnuncio(command.getIdAnuncio());
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/accept")
    public void aceitarLance(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody AceitarLanceCommand command) {
        service.aceitarLance(command);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/cancel")
    public void cancelarLance(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody CancelarLanceCommand command) {
        service.cancelarLance(command);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/menor-lance/{idAnuncio}")
    public AnuncioLance getMenorLanceDoAnuncio(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String idAnuncio) {
        return service.getMenorLanceDoAnuncio(idAnuncio);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/anuncios-que-dei-lance/{idPessoaLogada}")
    public Set<Anuncio> anunciosQueDeiLance(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String idPessoaLogada) {
        List<AnuncioLance> lances = service.anunciosQueDeiLance(idPessoaLogada);
        Set<Anuncio> anuncios = new HashSet<>();
        lances.forEach(anuncioLance -> anuncios.add(anuncioLance.getAnuncio()));
        return anuncios;
    }

}
