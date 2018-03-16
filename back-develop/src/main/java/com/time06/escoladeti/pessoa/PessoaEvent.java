package com.time06.escoladeti.pessoa;

public class PessoaEvent {

	private String id;
	private String tipoPessoa;
	private String telefone;
	private String celular;
	private String foto;

	public PessoaEvent(String id, String tipoPessoa, String telefone,
		   String celular, String foto) {
		
		this.id = id;
		this.tipoPessoa = tipoPessoa;
		this.telefone = telefone;
		this.celular = celular;
		this.foto = foto;
	}

	protected PessoaEvent() {
	}
	
	public String getId() {
		return id;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public String getTelefone() {
		return telefone;
	}
	
	public String getFoto() {
		return foto;
	}

	public String getCelular() {
		return celular;
	}
}
