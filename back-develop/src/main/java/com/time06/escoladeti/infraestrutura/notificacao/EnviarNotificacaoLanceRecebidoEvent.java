package com.time06.escoladeti.infraestrutura.notificacao;

public class EnviarNotificacaoLanceRecebidoEvent {

	private String idAnuncio;
	private String titulo;
	private String nome;
	private String email;

	public EnviarNotificacaoLanceRecebidoEvent(String id, String titulo, String nome, String email) {
		this.idAnuncio = id;
		this.titulo = titulo;
		this.nome = nome;
		this.email = email;
	}

	public String getId() {
		return idAnuncio;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
}
