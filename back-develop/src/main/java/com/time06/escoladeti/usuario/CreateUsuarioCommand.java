package com.time06.escoladeti.usuario;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.pessoa.PessoaCommand;

public class CreateUsuarioCommand  {

	private String id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	private String razaoSocial;
	private String fantasia;
	private String cnpj;
	private String inscricaoEstadual;
	private String tipoPessoa;
	private String cep;
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
	private String email;
	private String senha;

	@JsonCreator
	public CreateUsuarioCommand(
		@JsonProperty("nome") String nome,
		@JsonProperty("sobrenome") String sobrenome,
		@JsonProperty("cpf") String cpf,
		@JsonProperty("rg") String rg,
		@JsonProperty("razaoSocial") String razaoSocial,
		@JsonProperty("fantasia") String fantasia,
		@JsonProperty("cnpj") String cnpj,
		@JsonProperty("inscricaoEstadual") String inscricaoEstadual,
		@JsonProperty("tipoPessoa") String tipoPessoa,
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
		@JsonProperty("foto") String foto,
		@JsonProperty("email") String email,
		@JsonProperty("senha") String senha){
		
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
		this.email = email;
		this.senha = senha;
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

	public String getCelular() {
		return celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getFoto() {
		return foto;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
