package com.time06.escoladeti.usuario.alterar_usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitarAlteracaoEmailCommand {

	private String idUsuario;
	private String nome;

    @JsonCreator
    public SolicitarAlteracaoEmailCommand(
    		@JsonProperty("id") String id,
    		@JsonProperty("nome") String nome) {
        this.idUsuario = id;
    }
    
	public String getIdUsuario() {
		return idUsuario;
	}

	public String getNome() {
		return nome;
	}
}
