package com.time06.escoladeti.pessoa.pessoa_fisica;

public class PessoaFisicaEvent {

	private String id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String tipoPessoa;
	private String telefone;
	private String celular;
	private String foto;

	public PessoaFisicaEvent(String id, String nome, String sobrenome, String cpf,
		   String rg, String tipoPessoa, String telefone,
		   String celular, String foto) {
		
		this.id = id;
		this.nome = nome;
		this.sobrenome= sobrenome;
		this.cpf= cpf;
		this.rg = rg;
		this.tipoPessoa = tipoPessoa;
		this.telefone = telefone;
		this.celular = celular;
		this.foto = foto;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCelular() {
		return celular;
	}

	public String getFoto() {
		return foto;
	}
}
