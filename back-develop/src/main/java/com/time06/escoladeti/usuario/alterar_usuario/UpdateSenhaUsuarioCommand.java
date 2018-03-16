package com.time06.escoladeti.usuario.alterar_usuario;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateSenhaUsuarioCommand  {

	@NotNull (message = "Usuário exige uma Pessoa.")
	@NotEmpty (message = "Usuário exige uma Pessoa.")
	private String id;

	@NotNull
	@Size(min=6, message = "Senha deve conter no mínimo 6 caracteres.") 
	private String senha;

	@JsonCreator
	public UpdateSenhaUsuarioCommand(
		@JsonProperty("id") String id,
		@JsonProperty("senha") String novaSenha) {
		
		this.id = id;
		this.senha = novaSenha;
	}

	public String getId() {
		return id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
