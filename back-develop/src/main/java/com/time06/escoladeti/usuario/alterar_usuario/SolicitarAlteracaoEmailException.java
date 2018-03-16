package com.time06.escoladeti.usuario.alterar_usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "não foi possível solicitar a alteração de e-mail")
public class SolicitarAlteracaoEmailException extends RuntimeException {

}