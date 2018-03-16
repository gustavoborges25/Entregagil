package com.time06.escoladeti.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Este e-mail já está sendo utilizado por outro usuário.")
public class EmailDuplicadoException extends RuntimeException {

}
