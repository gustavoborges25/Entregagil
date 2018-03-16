package com.time06.escoladeti.infraestrutura.validador_token_usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exceção lançada quando o usuário não está autenticado. Deve ser tratada no front, já que
 * lá chegará um erro com HTTP Status 500.
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Usuário não autenticado. Favor fazer login novamente.")
public class UsuarioNaoAutenticadoException extends RuntimeException {

    public UsuarioNaoAutenticadoException() {
    }

}