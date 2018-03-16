package com.time06.escoladeti.usuario.alterar_usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateEmailUsuarioCommand {
	private String id;
	private String nome;
    private String novoEmail;
    private String token;

    @JsonCreator
    public UpdateEmailUsuarioCommand(
    		@JsonProperty("id") String id, 
    		@JsonProperty("nome") String nome,
    		@JsonProperty("novoEmail") String novoEmail,
    		@JsonProperty("token") String token) {
    	
        this.id = id;
        this.nome = nome;
        this.novoEmail = novoEmail;
        this.token = token;
    }

    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public String getNovoEmail() {
        return novoEmail;
    }
    
    public String getToken() {
        return token;
    }
}
