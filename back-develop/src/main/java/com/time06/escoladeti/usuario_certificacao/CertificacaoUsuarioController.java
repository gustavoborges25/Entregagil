package com.time06.escoladeti.usuario_certificacao;

import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import com.time06.escoladeti.usuario_certificacao.command_event.CreateDocumentoCommand;
import com.time06.escoladeti.usuario_certificacao.entity.CertificacaoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/certificacao")
public class CertificacaoUsuarioController {

    @Autowired
    public CertificacaoUsuarioService service;

    @ValidarUsuarioAutenticado
    @RequestMapping(method= RequestMethod.POST, value="/new/{idUsuario}/{proprietario}")
    public CertificacaoUsuario criaCertificacao(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario,
                                                @PathVariable String idUsuario,
                                                @PathVariable Boolean proprietario) {

        return service.criaCertificacao(idUsuario, proprietario);

    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method= RequestMethod.POST, value="/{idCertificacao}/addDocumento")
    public void addDocumento(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario,
                             @PathVariable String idCertificacao,
                             @RequestBody List<CreateDocumentoCommand> createDocumentosCommand) {

        for (CreateDocumentoCommand createDocumentoCommand : createDocumentosCommand) {
            service.addDocumento(idCertificacao, createDocumentoCommand);
        }

    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method= RequestMethod.GET, value="/{idUsuario}/possui")
    public ResponseEntity<Boolean> usuarioPossuiCertificacaoPago(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario,
                                                             @PathVariable String idUsuario) {

        return new ResponseEntity<>(service.usuarioPossuiCertificacaoPago(idUsuario), HttpStatus.OK);

    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method= RequestMethod.GET, value="/{idUsuario}")
    public CertificacaoUsuario getCertificacaoUsuario(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario,
                                                      @PathVariable String idUsuario) {

        return service.getCertificacaoUsuario(idUsuario);

    }

    @ValidarUsuarioAutenticado
    @RequestMapping(method= RequestMethod.POST, value="/{idUsuario}/receberPagamento")
    public void receberPagamento(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario,
                                 @PathVariable String idUsuario) {

        service.receberPagamento(idUsuario);

    }

}