package com.time06.escoladeti.infraestrutura;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não foi possível salvar a imagem.")
public class FileImagemException extends RuntimeException {

}
