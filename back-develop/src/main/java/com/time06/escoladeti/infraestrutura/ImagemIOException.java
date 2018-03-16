package com.time06.escoladeti.infraestrutura;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Foto está em um formato incorreto.")
public class ImagemIOException extends Exception {

}
