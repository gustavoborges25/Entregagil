package com.time06.escoladeti.infraestrutura.criptografia;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Problema na criptografia: dados informados incorretamente")
public class CriptografarStringException extends RuntimeException {

}
