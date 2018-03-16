package com.time06.escoladeti.infraestrutura.email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Ocorreu um problema ao tentar enviar o e-mail, por favor tente novamente mais tarde.")
public class FalhaAoEnviarEmailException extends RuntimeException {
}