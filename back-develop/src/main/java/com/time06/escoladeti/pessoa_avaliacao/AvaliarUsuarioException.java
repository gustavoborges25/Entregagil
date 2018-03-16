package com.time06.escoladeti.pessoa_avaliacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AvaliarUsuarioException extends RuntimeException {

    public AvaliarUsuarioException(String message) {
        super(message);
    }

}