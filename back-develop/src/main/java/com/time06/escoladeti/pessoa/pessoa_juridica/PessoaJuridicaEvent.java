package com.time06.escoladeti.pessoa.pessoa_juridica;

import org.apache.tomcat.util.codec.binary.Base64;

public class PessoaJuridicaEvent {

	private String id;
	private String razaoSocial;
	private String fantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private String tipoPessoa;
	private String telefone;
	private String celular;
	private String foto;

	public PessoaJuridicaEvent(String id, String razaoSocial, String fantasia, String cnpj,
		   String inscricaoEstadual, String tipoPessoa, String telefone,
		   String celular, String foto) {
		
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.tipoPessoa = tipoPessoa;
		this.telefone = telefone;
		this.celular = celular;
		this.foto = foto;

	}

	public String getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getFantasia() {
		return fantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
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
