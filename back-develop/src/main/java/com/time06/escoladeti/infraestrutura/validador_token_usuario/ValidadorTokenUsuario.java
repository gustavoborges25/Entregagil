package com.time06.escoladeti.infraestrutura.validador_token_usuario;

import com.time06.escoladeti.infraestrutura.login.LoginService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Aspecto que valida se o usuário que fez o request está autenticado.
 * Deve ser utilizado em todos os métodos dos controllers que só podem ser executados quando o usuário
 * está autenticado.
 * Para utilizar, anote o método com @ValidarUsuarioAutenticado.
 * REQUER que o primeiro parâmetro do método seja:
 *     @RequestHeader(value = TOKEN_USUARIO) String tokenUsuario
 * que é o token do usuário que será enviado no header da requisição.
 */
@Aspect
@Component
public class ValidadorTokenUsuario {

    public LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * Quando o método possuir a anotação @ValidarUsuarioAutenticado e seu primeiro parâmetro for
     * @RequestHeader(value = TOKEN_USUARIO) String tokenUsuario
     * o método abaixo será executado ANTES da execução do seu método. Aqui iremos validar
     * se o usuário está logado, ou seja, se seu token é um token válido. Caso não seja,
     * será lançada a exceção UsuarioNaoAutenticadoException, que deve ser tratada no front.
     */
    @Before("@annotation(com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado) && args(tokenUsuario,..)")
    public void validaTokenUsuario(JoinPoint joinPoint, String tokenUsuario) {
        if (!loginService.tokenExiste(tokenUsuario)) {
            throw new UsuarioNaoAutenticadoException();
        }
    }

}