package com.time06.escoladeti.usuario.alterar_usuario;

public class EnviarTokenAlteracaoEmailEvent {

	private String idUsuario;
	private String email;
	private String nome;

	public EnviarTokenAlteracaoEmailEvent(String IdUsuario, String email, String nome) {
		
		this.idUsuario = IdUsuario;
		this.email = email;
		this.nome = nome;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
}
