package com.time06.escoladeti.usuario;

public class CreateUsuarioEvent {

	private String id;
	private String email;
	private String senha;

	public CreateUsuarioEvent(String email, String senha) {
		
		this.email = email;
		this.senha = senha;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
}

