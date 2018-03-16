package com.time06.escoladeti.pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PessoaException extends RuntimeException {

	public PessoaException(String mensagem) {
		super(mensagem);
	}

}