package com.time06.escoladeti.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não foi possível realizar o cadastro do usuário.")
public class CreateUsuarioException extends RuntimeException {

}
