package com.time06.escoladeti.infraestrutura.confirmar_email;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não existe nenhum usuário com este e-mail.")
public class ConfirmarEmailEmailInvalidoException extends RuntimeException {

}
