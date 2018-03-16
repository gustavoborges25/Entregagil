package com.time06.escoladeti.infraestrutura.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * Gerencia o envio de e-mail. O endereço, usuário e senha estão definidos no application.properties.
 * Lembre-se de que é preciso habilitar a conta para poder ser acessada de aplicativos menos seguros,
 * utilizando este link: https://www.google.com/settings/security/lesssecureapps
 *
 * Tratamentos para as possíveis exceções devem ser feitos nesta classe.
 */
@Component
public class GerenciadorEmail {
	
	@Autowired
	private JavaMailSender javaMailSender;	
	
	public void enviar(Email email) {

		Thread thread = new Thread() {
			public void run() {
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper;

				try {
					helper = new MimeMessageHelper(message, true);
					helper.setSubject(email.getAssunto());
					helper.setTo(email.getPara());
					helper.setText(email.getMensagemHTML(), true);
				} catch (MessagingException e) {
					throw new FalhaAoCriarEmailException();
				}

				try {
					javaMailSender.send(message);
				} catch (MailException e) {
					throw new FalhaAoEnviarEmailException();
				}
			}
		};

		thread.start();
	}

}