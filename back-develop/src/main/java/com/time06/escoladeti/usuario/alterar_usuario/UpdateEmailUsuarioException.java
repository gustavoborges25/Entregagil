package com.time06.escoladeti.usuario.alterar_usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não foi possível atualizar o e-mail")
public class UpdateEmailUsuarioException extends RuntimeException {

}

