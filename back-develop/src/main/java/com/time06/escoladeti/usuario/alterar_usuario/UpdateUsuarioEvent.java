package com.time06.escoladeti.usuario.alterar_usuario;

public class UpdateUsuarioEvent {

	private String id;
	private String email;
	private String senha;
	private Boolean emailConfirmado;

	public UpdateUsuarioEvent(String id, String email, String senha, Boolean emailConfirmado) {
		
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.emailConfirmado = emailConfirmado;
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
	
	public Boolean getEmailConfirmado() {
		return emailConfirmado;
	}
}

