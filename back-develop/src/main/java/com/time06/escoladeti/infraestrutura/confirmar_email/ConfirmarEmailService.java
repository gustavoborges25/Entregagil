package com.time06.escoladeti.infraestrutura.confirmar_email;

import com.time06.escoladeti.infraestrutura.criptografia.CriptografarString;
import com.time06.escoladeti.infraestrutura.email.Email;
import com.time06.escoladeti.infraestrutura.email.GerenciadorEmail;
import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioRepository;
import com.time06.escoladeti.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfirmarEmailService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String ASSUNTO_EMAIL = "[EntregÁgil] Confirme o seu registro";
	private static final String MENSAGEM_EMAIL = "<p>Olá %s,</p><p>Para confirmar o seu e-mail clique no link abaixo.</p><p><a href=\"%s\">%s</a></p>";
    private static final String URL_CONFIRMAR_EMAIL = "http://127.0.0.1:%s/#/confirmar-email/%s";

    @Value("${server.port}")
    private String portaServidor;
    
	@Autowired
	private GerenciadorEmail gerenciadorEmail;

	@Autowired
	private UsuarioService usuarioService;
	
	public Usuario confirmarEmail(String emailCriptografado)  {
		try {
			
			Usuario usuario = usuarioService.findByEmail(CriptografarString.descriptografar(emailCriptografado));
			
			if (usuario != null) 
				usuario.setEmailConfirmado();
			
			usuarioRepository.save(usuario);
			return usuario;
			
		} catch (Exception e) {
			throw new ConfirmarEmailException();
		}
	}

	@Transactional
	public void enviaEmailDeConfirmacaoDeCadastro(EnviarConfirmacaoDeEmailEvent event) {
		Usuario usuario = usuarioService.findByEmail(event.getEmail());
		if (usuario == null) {
			throw new ConfirmarEmailEmailInvalidoException();
		}
		
		String emailCriptografado = CriptografarString.criptografar(event.getEmail());
		
		gerenciadorEmail.enviar(new Email()
				.para(event.getEmail())
				.comAssunto(ASSUNTO_EMAIL)
				.comMensagemHTML(String.format(MENSAGEM_EMAIL, usuario.getPessoa().getNome()
						, String.format(URL_CONFIRMAR_EMAIL, portaServidor, emailCriptografado)
						, String.format(URL_CONFIRMAR_EMAIL, portaServidor, emailCriptografado))));
	}

}