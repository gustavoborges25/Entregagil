package com.time06.escoladeti.infraestrutura.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.time06.escoladeti.Escoladeti2016time06Application;
import com.time06.escoladeti.usuario.CreateUsuarioCommand;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Escoladeti2016time06Application.class)
@WebAppConfiguration
@Transactional
public class LoginFunctionalTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    @Rollback
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        // Cria um usuário para poder logar depois
        CreateUsuarioCommand criarUsuarioCommand = new CreateUsuarioCommand(
                "MARCOS",
                "TANAKA",
                "18261528395",
                "53728393",
                "",
                "",
                null,
                null,
                "fisica",
                "RESIDENCIAL",
                "87033-220",
                "AVENIDA HORÁCIO RACCANELLO FILHO",
                "5410",
                "SOBRELOJA",
                "NOVO CENTRO",
                "MARINGÁ",
                "PARANÁ",
                "BRASIL",
                "4491621969",
                "4491621969",
                "teste.jpg",
                "marcosatanaka2@gmail.com",
                "123456");

        String json = new ObjectMapper().writeValueAsString(criarUsuarioCommand);
        mockMvc.perform(post("/usuario/cadastrar-usuario")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Rollback
    public void deve_logar() throws Exception {
        LogarCommand logarCommand = new LogarCommand("marcosatanaka2@gmail.com", "123456");

        MockHttpServletRequestBuilder logar = post("/login")
                .content(new ObjectMapper().writeValueAsString(logarCommand))
                .contentType(MediaType.APPLICATION_JSON);

        ResultActions result = mockMvc.perform(logar);

        result.andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

}