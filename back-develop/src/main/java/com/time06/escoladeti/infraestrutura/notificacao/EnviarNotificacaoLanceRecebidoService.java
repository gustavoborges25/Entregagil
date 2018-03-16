package com.time06.escoladeti.infraestrutura.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.time06.escoladeti.infraestrutura.email.Email;
import com.time06.escoladeti.infraestrutura.email.GerenciadorEmail;

@Service
public class EnviarNotificacaoLanceRecebidoService {
	
	private static final String ASSUNTO_EMAIL = "[EntregÁgil] Você recebeu um novo lance";
	private static final String MENSAGEM_EMAIL = "<p>Olá %s, você recebeu um novo lance, clique no link e confira.</p><p>.</p><p><a href=\"%s\">%s</a></p>";
    private static final String URL_CONFIRMAR_EMAIL = "http://127.0.0.1:%s/#/anuncio-detalhe/%s";

    @Value("${server.port}")
    private String portaServidor;
    
	@Autowired
	private GerenciadorEmail gerenciadorEmail;
	
	public void enviaEmailLanceRecebido(EnviarNotificacaoLanceRecebidoEvent event) {
		
		gerenciadorEmail.enviar(new Email()
				.para(event.getEmail())
				.comAssunto(ASSUNTO_EMAIL)
				.comMensagemHTML(String.format(MENSAGEM_EMAIL, event.getNome()
						, String.format(URL_CONFIRMAR_EMAIL, portaServidor, event.getId())
						, String.format(URL_CONFIRMAR_EMAIL, portaServidor, event.getId()))));
	}

	
}
