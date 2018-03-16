package com.time06.escoladeti.infraestrutura.confirmar_email;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReenviarEmailDeConfirmacaoDeEmailCommand {

	private String email;
	private String nome;

    @JsonCreator
    public ReenviarEmailDeConfirmacaoDeEmailCommand(
    		@JsonProperty("nome") String nome,
    		@JsonProperty("email") String email) {
        this.email = email;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    
    public String getNome() {
        return nome;
    }
}
