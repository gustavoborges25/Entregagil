package com.time06.escoladeti.anuncio_lance.entity;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Lances cancelados não podem ser aceitos.")
public class AnuncioLanceAceitarException extends RuntimeException {
}
