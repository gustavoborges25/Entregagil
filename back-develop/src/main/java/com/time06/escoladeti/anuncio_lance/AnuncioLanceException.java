package com.time06.escoladeti.anuncio_lance;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnuncioLanceException extends RuntimeException {

    public AnuncioLanceException(String message) {
        super(message);
    }

}