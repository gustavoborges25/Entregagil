package com.time06.escoladeti.infraestrutura.redefinir_senha;

import com.time06.escoladeti.infraestrutura.email.Email;
import com.time06.escoladeti.infraestrutura.email.GerenciadorEmail;
import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RedefinirSenhaService {

    @Value("${server.port}")
    private String portaServidor;

    private UsuarioService usuarioService;

    @Autowired
    private RedefinirSenhaRepository repository;

    private GerenciadorEmail gerenciadorEmail;

    protected static final String ASSUNTO_EMAIL = "[EntregaÁgil] Redefinição de Senha";
    protected static final String MENSAGEM_EMAIL = "<p>Olá %s,</p><p>Você recentemente esqueceu sua senha de acesso ao EntregaÁgil.</p><p>Por favor, clique no link abaixo para definir uma nova senha:</p><p><a href=\"%s\">%s</a></p>";
    public static final String URL_REDEFINICAO_SENHA = "http://127.0.0.1:%s/#/redefinirSenha/%s";

    @Autowired
    public void setRepository(RedefinirSenhaRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setGerenciadorEmail(GerenciadorEmail gerenciadorEmail) {
        this.gerenciadorEmail = gerenciadorEmail;
    }


    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    private TokenRedefinicaoSenha atualizaToken(Usuario usuario) {
        TokenRedefinicaoSenha tokenAntigo = getToken(usuario);
        if (tokenAntigo != null) {
            repository.delete(tokenAntigo);
        }
        TokenRedefinicaoSenha tokenGeradoParaUsuario = new TokenRedefinicaoSenha(usuario);
        return repository.save(tokenGeradoParaUsuario);
    }

    @Transactional(rollbackFor = Exception.class)
    public void enviaEmailComTokenParaRedefinicaoSenha(SolicitarRedefinicaoSenhaCommand command) {
        Usuario usuariosCorrespondente = usuarioService.findByEmail(command.getEmail());
        if (usuariosCorrespondente == null) {
            throw new RedefinirSenhaEmailInvalidoException();
        }

        Usuario usuario = usuariosCorrespondente;
        TokenRedefinicaoSenha token = atualizaToken(usuario);

        gerenciadorEmail.enviar(new Email()
                                    .para(usuario.getEmail())
                                    .comAssunto(ASSUNTO_EMAIL)
                                    .comMensagemHTML(String.format(MENSAGEM_EMAIL, usuario.getPessoa().getNome()
                                                                                 , String.format(URL_REDEFINICAO_SENHA, portaServidor, token.getToken())
                                                                                 , String.format(URL_REDEFINICAO_SENHA, portaServidor, token.getToken()))));
    }

    private TokenRedefinicaoSenha getToken(Usuario usuario) {
        List<TokenRedefinicaoSenha> tokens = repository.findByUsuarioId(usuario.getId());
        if (!tokens.isEmpty()) {
            return tokens.get(0);
        }
        return null;
    }

    public Usuario getUsuarioAssociadoAoTokenDeRedefinicaoDeSenha(String token) {
        TokenRedefinicaoSenha tokenRedefinicaoSenha = repository.findOne(token);
        if (tokenRedefinicaoSenha == null) {
            throw new RedefinirSenhaTokenInvalidoException();
        }
        return tokenRedefinicaoSenha.getUsuario();
    }

    @Transactional(rollbackFor = Exception.class)
    public void atualizarSenhaUsuario(AtualizarSenhaCommand command) {
        Usuario usuario = usuarioService.findOne(command.getIdUsuario());
        usuarioService.atualizarSenhaUsuario(usuario, command.getNovaSenha());
    }

}