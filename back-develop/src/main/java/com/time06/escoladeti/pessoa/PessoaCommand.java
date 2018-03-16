package com.time06.escoladeti.pessoa;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PessoaCommand {

	private String id;
	public String nome;
	public String sobrenome;
	public String cpf;
	public String rg;
	public String razaoSocial;
	public String fantasia;
	public String cnpj;
	public String inscricaoEstadual;
	public String tipoPessoa;
	private String cep;
	private String idEndereco;
	private String endereco;
	private String numero;
	private String bairro;
	private String tipoEndereco;
	private String complemento;
	private String cidade;
	private String estado;
	private String pais;
	private String telefone;
	private String celular;
	private String foto;

	@JsonCreator
	public PessoaCommand(
		@JsonProperty("id") String id,
		@JsonProperty("nome") String nome,
		@JsonProperty("sobrenome") String sobrenome,
		@JsonProperty("cpf") String cpf,
		@JsonProperty("rg") String rg,
		@JsonProperty("razaoSocial") String razaoSocial,
		@JsonProperty("fantasia") String fantasia,
		@JsonProperty("cnpj") String cnpj,
		@JsonProperty("inscricaoEstadual") String inscricaoEstadual,
		@JsonProperty("tipoPessoa") String tipoPessoa,
		@JsonProperty("idEndereco") String idEndereco,
		@JsonProperty("tipoEndereco") String tipoEndereco,
		@JsonProperty("cep") String cep,
		@JsonProperty("endereco") String endereco,
		@JsonProperty("numero") String numero,
		@JsonProperty("complemento") String complemento,
		@JsonProperty("bairro") String bairro,
		@JsonProperty("cidade") String cidade,
		@JsonProperty("estado") String estado,
		@JsonProperty("pais") String pais,
		@JsonProperty("telefone") String telefone,
		@JsonProperty("celular") String celular,
		@JsonProperty("foto") String foto) {
		
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.rg = rg;
		this.razaoSocial = razaoSocial;
		this.fantasia = fantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.tipoPessoa = tipoPessoa;
		this.tipoEndereco = tipoEndereco;
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.telefone = telefone;
		this.celular = celular;
		this.foto = foto;
		
	}
	
	public String getIdEndereco() {
		return idEndereco;
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

	public String getCelular() {
		return celular;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public String getFoto() {
		return foto;
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

	public String getPais() {
		return pais;
	}
}
