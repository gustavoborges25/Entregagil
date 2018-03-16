package com.time06.escoladeti.infraestrutura.redefinir_senha;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Usada na redefinição de senha (esqueci minha senha), quando não é
 * encontrado nenhum usuário vinculado a este e-mail.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Não existe nenhum usuário com este e-mail.")
public class RedefinirSenhaEmailInvalidoException extends RuntimeException {
}