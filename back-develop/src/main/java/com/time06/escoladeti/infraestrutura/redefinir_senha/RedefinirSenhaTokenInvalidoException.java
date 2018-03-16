package com.time06.escoladeti.infraestrutura.redefinir_senha;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Usada na redefinição de senha (esqueci minha senha), quando não é
 * encontrado nenhum usuário vinculado a este e-mail.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Link inválido ou expirado, por favor, tente redefinir sua senha novamente.")
public class RedefinirSenhaTokenInvalidoException extends RuntimeException {
}