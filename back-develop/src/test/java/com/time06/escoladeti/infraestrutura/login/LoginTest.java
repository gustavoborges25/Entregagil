package com.time06.escoladeti.infraestrutura.login;

import com.time06.escoladeti.Escoladeti2016time06Application;
import com.time06.escoladeti.infraestrutura.validador_token_usuario.UsuarioNaoAutenticadoException;
import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Escoladeti2016time06Application.class)
public class LoginTest {

    @Autowired
    private LoginController controller;

    @Autowired
    private LoginService service;

    @Mock
    private LoginRepository repository;

    @Mock
    private UsuarioService usuarioService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        service.setRepository(repository);
        service.setUsuarioService(usuarioService);
    }

    @Test
    public void deve_retornar_novo_token_quando_existe_usuario_com_este_email_e_senha() {
        // Prepara retornos para que passe pelo fluxo de login ok
        List<Usuario> usuariosCorrespondentes = new ArrayList<>();
        usuariosCorrespondentes.add(Mockito.mock(Usuario.class));
        Mockito.doReturn(usuariosCorrespondentes).when(usuarioService).findByEmailAndSenha(Mockito.any());
        Mockito.doReturn(Mockito.mock(Token.class)).when(repository).save(Mockito.any(Token.class));

        Token token = controller.logar(new LogarCommand("email", "senha"));

        // Deve salvar o token novo
        Mockito.verify(repository, times(1)).save(Mockito.any(Token.class));

        Assert.assertNotNull(token);
    }

    @Test(expected = UsuarioNaoAutenticadoException.class)
    public void deve_lancar_excecao_quando_nao_existe_usuario_com_este_email_e_senha() {
        controller.logar(new LogarCommand("email", "senha"));
    }

    @Test
    public void deve_apagar_token_antigo_do_usuario_com_este_email_e_senha_e_salvar_e_retornar_um_novo() {
        Usuario usuario = Mockito.mock(Usuario.class);
        Mockito.doReturn("f7b7521c-75ba-4d75-8268-cbe35c36c430").when(usuario).getId();

        // Prepara retornos para que passe pelo fluxo de login ok
        List<Usuario> usuariosCorrespondentes = new ArrayList<>();
        usuariosCorrespondentes.add(usuario);
        Mockito.doReturn(usuariosCorrespondentes).when(usuarioService).findByEmailAndSenha(Mockito.any());

        // Prepara retorno do token
        List<Token> tokens = new ArrayList<>();
        Token token = Mockito.mock(Token.class);
        tokens.add(token);
        Mockito.doReturn(tokens).when(repository).findByUsuarioId("f7b7521c-75ba-4d75-8268-cbe35c36c430");

        Mockito.doReturn(Mockito.mock(Token.class)).when(repository).save(Mockito.any(Token.class));

        Token token2 = controller.logar(new LogarCommand("email", "senha"));

        // Deve apagar o token antigo
        Mockito.verify(repository, times(1)).delete(token);

        // Deve salvar o token novo
        Mockito.verify(repository, times(1)).save(Mockito.any(Token.class));

        Assert.assertNotNull(token2);
    }

    @Test
    public void deve_retornar_true_caso_token_existe_no_banco() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(Mockito.mock(Token.class));
        Mockito.doReturn(tokens).when(repository).findByToken("ba7d0394-9795-4e25-a2ce-f05a762a2cd9");

        Assert.assertTrue(service.tokenExiste("ba7d0394-9795-4e25-a2ce-f05a762a2cd9"));
    }

    @Test
    public void deve_retornar_false_caso_token_nao_existe_no_banco() {
        List<Token> tokens = new ArrayList<>();
        tokens.add(Mockito.mock(Token.class));
        Mockito.doReturn(tokens).when(repository).findByToken("2de0c050-3c0f-4657-839c-9b3e731cc4ad");

        Assert.assertFalse(service.tokenExiste("ba7d0394-9795-4e25-a2ce-f05a762a2cd9"));
    }

}