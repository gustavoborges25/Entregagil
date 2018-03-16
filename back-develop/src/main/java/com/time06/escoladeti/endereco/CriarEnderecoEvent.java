package com.time06.escoladeti.endereco;

public class CriarEnderecoEvent {
	
	private String id;
	private String cep;
	private String endereco;
	private String numero;
	private String bairro;
	private String tipoEndereco;
	private String complemento;
	private String cidade;
	private String estado;

	protected CriarEnderecoEvent() {
		// TODO Auto-generated constructor stub
	}
	
	public CriarEnderecoEvent(String id, String cep, String endereco, String numero, String bairro,
	String tipoEndereco, String complemento, String cidade, String estado) {

		this.id = id;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.tipoEndereco = tipoEndereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getId() {
		return id;
	}
	
	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
}
