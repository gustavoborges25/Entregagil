package com.time06.escoladeti.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Problema ao tentar cadastrar usuário.")
public class UsuarioException extends RuntimeException {

	public UsuarioException(String mensagem) {
		super(mensagem);
	}
}
