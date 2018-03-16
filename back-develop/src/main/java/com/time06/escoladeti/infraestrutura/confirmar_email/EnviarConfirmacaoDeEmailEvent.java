package com.time06.escoladeti.infraestrutura.confirmar_email;

public class EnviarConfirmacaoDeEmailEvent {

	private String email;
	private String nome;

	public EnviarConfirmacaoDeEmailEvent(String email, String nome) {
		
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
