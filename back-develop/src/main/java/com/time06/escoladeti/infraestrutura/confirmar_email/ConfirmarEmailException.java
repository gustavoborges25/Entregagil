package com.time06.escoladeti.infraestrutura.confirmar_email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Link de confirmação de e-mail inválido")
public class ConfirmarEmailException extends RuntimeException {
	
}
