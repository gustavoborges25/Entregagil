package com.time06.escoladeti.infraestrutura.validador_token_usuario;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Deve ser colocada em cima dos métodos que só podem ser executados caso o usuário esteja
 * autenticado. Em conjunto com esta anotação, é necessário que o primeiro parâmetro do
 * método seja o seguinte:
 *
 * @RequestHeader(value = TOKEN_USUARIO) String tokenUsuario
 *
 * Que é o token do usuário e será enviado no header da requisição.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidarUsuarioAutenticado {



}