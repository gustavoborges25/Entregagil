package com.time06.escoladeti.infraestrutura.redefinir_senha;

import com.time06.escoladeti.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/redefinirSenha")
public class RedefinirSenhaController {

    @Autowired
    private RedefinirSenhaService service;

    /**
     * O fluxo de redefinição de senha começa por aqui, quando o usuário clica em
     * Esqueci minha senha. É gerado um token único, associado ao usuário, e enviado
     * por e-mail juntamente com o link que aponta para a rota do método autenticaRedefinicaoSenha.
     */
    @RequestMapping(method = RequestMethod.POST)
    public void enviaEmailComTokenParaRedefinicaoSenha(@RequestBody SolicitarRedefinicaoSenhaCommand command) {
        service.enviaEmailComTokenParaRedefinicaoSenha(command);
    }

    /**
     * Aqui, é validado o token de redefinição de senha para pegar o usuário
     * associado. Se não encontrado, lança exceção. Se encontrado, retorna o
     * usuário associado.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{token}")
    public Usuario autenticaRedefinicaoSenha(@PathVariable String token) {
        return service.getUsuarioAssociadoAoTokenDeRedefinicaoDeSenha(token);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/novaSenha")
    public void atualizaSenha(@RequestBody AtualizarSenhaCommand command) {
        service.atualizarSenhaUsuario(command);
    }

}