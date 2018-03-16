package com.time06.escoladeti.usuario.alterar_usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.time06.escoladeti.infraestrutura.email.Email;
import com.time06.escoladeti.infraestrutura.email.GerenciadorEmail;
import com.time06.escoladeti.infraestrutura.redefinir_senha.RedefinirSenhaTokenInvalidoException;
import com.time06.escoladeti.infraestrutura.redefinir_senha.TokenRedefinicaoSenha;
import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioService;

@Service
public class TokenAlterarEmailService {

	@Autowired
	private TokenAlterarEmailRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
    private GerenciadorEmail gerenciadorEmail;
    
    
    private static final String ASSUNTO_EMAIL = "[EntregaÁgil] Alteração de E-mail";
    private static final String MENSAGEM_EMAIL = "<p>Olá %s,</p><p>Recebemos uma solicitação para alteração de e-mail associada a sua conta. Se você fez essa solicitação, por favor, confirme clicando no link abaixo.</p><p><a href=\"%s\">Solicitei a alteração e desejo informar o novo e-mail.</a></p>";
    public static final String URL_ALTERACAO_EMAIL = "http://127.0.0.1:8081/#/alterarEmail/%s";
	
	
	@Transactional(rollbackFor = Exception.class)
	public void enviarLinkParaAlteracaoDeEmail(EnviarTokenAlteracaoEmailEvent event) {
		
		Usuario usuario = usuarioService.findOne(event.getIdUsuario());
		
		TokenAlterarEmail token = new TokenAlterarEmail(usuario);
		repository.save(token);
		
		
		gerenciadorEmail.enviar(new Email()
                .para(event.getEmail())
                .comAssunto(ASSUNTO_EMAIL)
                .comMensagemHTML(String.format(MENSAGEM_EMAIL, event.getNome()
                                                             , String.format(URL_ALTERACAO_EMAIL, token.getToken())
                                                             , String.format(URL_ALTERACAO_EMAIL, token.getToken()))));
		
	}
	
	public Usuario getUsuarioAssociadoAoTokenDeAteracaoDeEmail(String token) {
        TokenAlterarEmail tokenAlterarEmail = repository.findOne(token);
        if (tokenAlterarEmail == null) {
            throw new AlterarEmailTokenInvalidoException();
        }
        return tokenAlterarEmail.getUsuario();
    }

	public void delete(String token) {
		repository.deleteToken(token);		
	}
}
