package com.time06.escoladeti.infraestrutura.validador_token_usuario;

import com.time06.escoladeti.Escoladeti2016time06Application;
import com.time06.escoladeti.infraestrutura.login.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Escoladeti2016time06Application.class)
public class ValidadorTokenUsuarioTest {

    @Autowired
    private ValidadorTokenUsuario validadorTokenUsuario;

    @Mock
    public LoginService loginService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        validadorTokenUsuario.setLoginService(loginService);
    }

    @Test(expected = UsuarioNaoAutenticadoException.class)
    public void deve_lancar_excecao_quando_nao_encontra_usuario_pelo_token() {
        Mockito.doReturn(false).when(loginService).tokenExiste("");
        validadorTokenUsuario.validaTokenUsuario(null, "");
    }

    @Test
    public void nao_faz_nada_quando_encontra_usuario_pelo_token() {
        Mockito.doReturn(true).when(loginService).tokenExiste("");
        validadorTokenUsuario.validaTokenUsuario(null, "");
    }

}