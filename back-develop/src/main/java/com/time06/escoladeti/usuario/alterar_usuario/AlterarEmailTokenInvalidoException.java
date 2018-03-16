package com.time06.escoladeti.usuario.alterar_usuario;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Link inválido ou expirado, por favor, tente alterar seu e-mail novamente.")
public class AlterarEmailTokenInvalidoException extends RuntimeException {
}