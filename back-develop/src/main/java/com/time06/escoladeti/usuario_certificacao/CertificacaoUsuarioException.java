package com.time06.escoladeti.usuario_certificacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CertificacaoUsuarioException extends RuntimeException {

    public CertificacaoUsuarioException(String message) {
        super(message);
    }
}