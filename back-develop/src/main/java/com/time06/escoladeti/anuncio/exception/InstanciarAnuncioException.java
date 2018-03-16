package com.time06.escoladeti.anuncio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InstanciarAnuncioException extends RuntimeException {

    public InstanciarAnuncioException(String message) {
        super(message);
    }

}