package com.time06.escoladeti.infraestrutura.login;

import com.time06.escoladeti.infraestrutura.validador_token_usuario.UsuarioNaoAutenticadoException;
import com.time06.escoladeti.usuario.LogarUsuarioEvent;
import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LoginService {

    private LoginRepository repository;
    private UsuarioService usuarioService;

    @Autowired
    public void setRepository(LoginRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Token logar(LogarCommand command) {
        Usuario usuarioParaAutenticar = new Usuario(new LogarUsuarioEvent(command.getEmail(), command.getSenha()));
        List<Usuario> usuariosCorrespondentes = usuarioService.findByEmailAndSenha(usuarioParaAutenticar);

        if (usuariosCorrespondentes.isEmpty()) {
            throw new UsuarioNaoAutenticadoException();
        }

        Usuario usuarioAutenticado = usuariosCorrespondentes.get(0);
        Token token = atualizaToken(usuarioAutenticado);
        return token;
    }

    private Token atualizaToken(Usuario usuario) {
        Token tokenAntigo = getToken(usuario);
        if (tokenAntigo != null) {
            repository.delete(tokenAntigo);
        }
        Token tokenGeradoParaUsuario = new Token(usuario);
        return repository.save(tokenGeradoParaUsuario);
    }

    private Token getToken(Usuario usuario) {
        List<Token> tokens = repository.findByUsuarioId(usuario.getId());
        if (!tokens.isEmpty()) {
            return tokens.get(0);
        }
        return null;
    }

    @Transactional
    public Boolean tokenExiste(String token) {
        List<Token> tokens = repository.findByToken(token);
        return !tokens.isEmpty();
    }

}