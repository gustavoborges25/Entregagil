package com.time06.escoladeti.infraestrutura.confirmar_email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não foi possível enviar e-mail de confirmação de cadastro.")
public class EnviarEmailDeConfirmacaoException extends RuntimeException {

}
