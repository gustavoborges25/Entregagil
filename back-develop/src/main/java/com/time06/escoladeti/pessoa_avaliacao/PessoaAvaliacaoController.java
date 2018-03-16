package com.time06.escoladeti.pessoa_avaliacao;

import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import com.time06.escoladeti.pessoa_avaliacao.command_event.AvaliarAnuncianteCommand;
import com.time06.escoladeti.pessoa_avaliacao.command_event.AvaliarTransportadorCommand;
import com.time06.escoladeti.pessoa_avaliacao.entity.PessoaAvaliacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoa-avaliacao")
public class PessoaAvaliacaoController {

    @Autowired
    private PessoaAvaliacaoService service;

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/avaliar-anunciante")
    public void avaliarAnunciante(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody AvaliarAnuncianteCommand command) {
        service.avaliarAnunciante(command);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.POST, value = "/avaliar-transportador")
    public void avaliarTransportador(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @RequestBody AvaliarTransportadorCommand command) {
        service.avaliarTransportador(command);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/feitas-por/{idAvaliador}")
    public List<PessoaAvaliacao> getAvaliacoesFeitasPor(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idAvaliador") String idAvaliador) {
        return service.getAvaliacoesFeitasPor(idAvaliador);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/feitas-para/{idAvaliado}/comoAnunciante")
    public List<PessoaAvaliacao> getAvaliacoesFeitasParaComoAnunciante(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idAvaliado") String idAvaliado) {
        return service.getAvaliacoesFeitasParaComoAnunciante(idAvaliado);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/feitas-para/{idAvaliado}/comoTransportador")
    public List<PessoaAvaliacao> getAvaliacoesFeitasParaComoTransportador(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("idAvaliado") String idAvaliado) {
        return service.getAvaliacoesFeitasParaComoTransportador(idAvaliado);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public PessoaAvaliacao getAvaliacao(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getAvaliacao(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/media-tempo-entrega/{id}")
    public double getMediaTempoEntrega(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getMediaTempoEntrega(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/media-integridade-mercadoria/{id}")
    public double getMediaIntegridadeMercadoria(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getMediaIntegridadeMercadoria(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/media-estrelas-anunciante/{id}")
    public double getMediaEstrelasAnuniante(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getMediaEstrelasAnunciante(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/media-estrelas-transportador/{id}")
    public double getMediaEstrelasTransportador(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getMediaEstrelasTransportador(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/percentual-recomendacoes-transportador/{id}")
    public double getPercentualRecomendacoesTransportador(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getPercentualRecomendacoesTransportador(id);
    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method = RequestMethod.GET, value = "/qtde-transportes-finalizados/{id}")
    public long getQtdeTransportesFinalizados(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable("id") String id) {
        return service.getQtdeTransportesFinalizados(id);
    }

}