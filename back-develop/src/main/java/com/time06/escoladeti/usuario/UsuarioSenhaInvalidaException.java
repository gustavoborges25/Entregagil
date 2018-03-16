package com.time06.escoladeti.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Senha deve conter no mínimo 6 caracteres.")
public class UsuarioSenhaInvalidaException extends RuntimeException {
	
}

