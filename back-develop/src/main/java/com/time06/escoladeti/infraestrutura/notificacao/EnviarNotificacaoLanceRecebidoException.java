package com.time06.escoladeti.infraestrutura.notificacao;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não foi possível enviar a notificação para o Transportador.")
public class EnviarNotificacaoLanceRecebidoException extends RuntimeException {

	
	
}
