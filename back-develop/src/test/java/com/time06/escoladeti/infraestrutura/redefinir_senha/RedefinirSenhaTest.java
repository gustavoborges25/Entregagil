package com.time06.escoladeti.infraestrutura.redefinir_senha;

import com.time06.escoladeti.Escoladeti2016time06Application;
import com.time06.escoladeti.infraestrutura.email.Email;
import com.time06.escoladeti.infraestrutura.email.GerenciadorEmail;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Escoladeti2016time06Application.class)
public class RedefinirSenhaTest {

    @Autowired
    private RedefinirSenhaService service;

    @Mock
    private UsuarioService usuarioService;

    @Mock
    private RedefinirSenhaRepository repository;

    @Mock
    private GerenciadorEmail gerenciadorEmail;

    @Value("${server.port}")
    private String portaServidor;

    @Before
    @Rollback
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        service.setUsuarioService(usuarioService);
        service.setRepository(repository);
        service.setGerenciadorEmail(gerenciadorEmail);
    }

    @Test(expected = RedefinirSenhaEmailInvalidoException.class)
    public void deve_lancar_excecao_quando_usuario_nao_existe() {
        Mockito.doReturn(Collections.EMPTY_LIST).when(usuarioService).findByEmail("marcos@gmail.com");
        service.enviaEmailComTokenParaRedefinicaoSenha(new SolicitarRedefinicaoSenhaCommand("marcos@gmail.com"));
    }

    @Test
    public void deve_enviar_email_para_usuario_com_token_para_redefinicao_da_senha() {
        // Mock do usuário pesquisado
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = Mockito.mock(Usuario.class);
        Mockito.doReturn("a").when(usuario).getId();
        Mockito.doReturn("marcos@gmail.com").when(usuario).getEmail();
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        Mockito.doReturn("Marcos Tanaka").when(pessoa).getNome();
        Mockito.doReturn(pessoa).when(usuario).getPessoa();
        usuarios.add(usuario);
        Mockito.doReturn(usuarios).when(usuarioService).findByEmail("marcos@gmail.com");

        // Mock dos tokens de redefinição de senha anteriores
        Mockito.doReturn(Collections.EMPTY_LIST).when(repository).findByUsuarioId("a");

        // Mock do token de redefinição de senha que será criado
        TokenRedefinicaoSenha tokenRedefinicaoSenha = Mockito.mock(TokenRedefinicaoSenha.class);
        Mockito.doReturn("123").when(tokenRedefinicaoSenha).getToken();
        Mockito.doReturn(tokenRedefinicaoSenha).when(repository).save(Mockito.any(TokenRedefinicaoSenha.class));

        // Assert
        service.enviaEmailComTokenParaRedefinicaoSenha(new SolicitarRedefinicaoSenhaCommand("marcos@gmail.com"));
        Mockito.verify(repository, times(1)).save(Mockito.any(TokenRedefinicaoSenha.class));

        ArgumentCaptor<Email> emailEnviado = ArgumentCaptor.forClass(Email.class);
        Mockito.verify(gerenciadorEmail, times(1)).enviar(emailEnviado.capture());
        Email emailEnviadoValue = emailEnviado.getValue();
        Assert.assertEquals("marcos@gmail.com", emailEnviadoValue.getPara());
        Assert.assertEquals(RedefinirSenhaService.ASSUNTO_EMAIL, emailEnviadoValue.getAssunto());
        Assert.assertEquals(String.format(RedefinirSenhaService.MENSAGEM_EMAIL
                , usuario.getPessoa().getNome()
                , String.format(RedefinirSenhaService.URL_REDEFINICAO_SENHA, portaServidor, "123")
                , String.format(RedefinirSenhaService.URL_REDEFINICAO_SENHA, portaServidor, "123"))
                , emailEnviadoValue.getMensagemHTML());
    }

    @Test
    public void deve_enviar_email_para_usuario_com_token_para_redefinicao_da_senha_e_apagar_tokens_anteriores() {
        // Mock do usuário pesquisado
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = Mockito.mock(Usuario.class);
        Mockito.doReturn("a").when(usuario).getId();
        Mockito.doReturn("marcos@gmail.com").when(usuario).getEmail();
        Pessoa pessoa = Mockito.mock(Pessoa.class);
        Mockito.doReturn("Marcos Tanaka").when(pessoa).getNome();
        Mockito.doReturn(pessoa).when(usuario).getPessoa();
        usuarios.add(usuario);
        Mockito.doReturn(usuarios).when(usuarioService).findByEmail("marcos@gmail.com");

        // Mock dos tokens de redefinição de senha anteriores
        List<TokenRedefinicaoSenha> tokensAntigos = new ArrayList<>();
        TokenRedefinicaoSenha tokenRedefinicaoSenhaAntigo = Mockito.mock(TokenRedefinicaoSenha.class);
        tokensAntigos.add(tokenRedefinicaoSenhaAntigo);
        Mockito.doReturn(tokensAntigos).when(repository).findByUsuarioId("a");


        // Mock do token de redefinição de senha que será criado
        TokenRedefinicaoSenha tokenRedefinicaoSenha = Mockito.mock(TokenRedefinicaoSenha.class);
        Mockito.doReturn("123").when(tokenRedefinicaoSenha).getToken();
        Mockito.doReturn(tokenRedefinicaoSenha).when(repository).save(Mockito.any(TokenRedefinicaoSenha.class));

        // Assert
        service.enviaEmailComTokenParaRedefinicaoSenha(new SolicitarRedefinicaoSenhaCommand("marcos@gmail.com"));
        Mockito.verify(repository, times(1)).save(Mockito.any(TokenRedefinicaoSenha.class));
        Mockito.verify(repository).delete(tokenRedefinicaoSenhaAntigo);

        ArgumentCaptor<Email> emailEnviado = ArgumentCaptor.forClass(Email.class);
        Mockito.verify(gerenciadorEmail, times(1)).enviar(emailEnviado.capture());
        Email emailEnviadoValue = emailEnviado.getValue();
        Assert.assertEquals("marcos@gmail.com", emailEnviadoValue.getPara());
        Assert.assertEquals(RedefinirSenhaService.ASSUNTO_EMAIL, emailEnviadoValue.getAssunto());
        Assert.assertEquals(String.format(RedefinirSenhaService.MENSAGEM_EMAIL
                , usuario.getPessoa().getNome()
                , String.format(RedefinirSenhaService.URL_REDEFINICAO_SENHA, portaServidor, "123")
                , String.format(RedefinirSenhaService.URL_REDEFINICAO_SENHA, portaServidor, "123"))
                , emailEnviadoValue.getMensagemHTML());
    }

}