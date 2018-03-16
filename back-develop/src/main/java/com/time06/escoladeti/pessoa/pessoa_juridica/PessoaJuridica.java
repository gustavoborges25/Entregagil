package com.time06.escoladeti.pessoa.pessoa_juridica;

import static com.time06.escoladeti.infraestrutura.Util.vazio;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa.PessoaEvent;
import com.time06.escoladeti.pessoa.PessoaException;

@Entity
public class PessoaJuridica extends Pessoa {

	private String razaoSocial;
	private String fantasia;
	private String cnpj;
	private String inscricaoEstadual;
	
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaJuridica(PessoaJuridicaEvent event, Endereco endereco) {
		super(new PessoaEvent("", event.getTipoPessoa(), event.getTelefone(),
				event.getCelular(), event.getFoto()), endereco);
		
		requerRazaoSocialNaoNulo(event.getRazaoSocial());
		requerFantasiaNaoNulo(event.getFantasia());
		requerCnpjNaoNulo(event.getCnpj());
		requerInscricaoEstadualNaoNulo(event.getInscricaoEstadual());
		
		this.razaoSocial = event.getRazaoSocial();
		this.fantasia = event.getFantasia();
		this.cnpj = event.getCnpj();
		this.inscricaoEstadual = event.getInscricaoEstadual();
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

	private void requerInscricaoEstadualNaoNulo(String inscricaoEstadual) {
		if (vazio(inscricaoEstadual))
		throw new PessoaException("Pessoa exige uma Inscrição Estadual!");	
	}

	private void requerCnpjNaoNulo(String cnpj) {
		if (vazio(cnpj))
			throw new PessoaException("Pessoa exige um CNPJ!");
	}

	private void requerFantasiaNaoNulo(String fantasia) {
		if (vazio(fantasia))
			throw new PessoaException("Pessoa exige uma Fantasia!");
	}

	private void requerRazaoSocialNaoNulo(String razaoSocial) {
		if (vazio(razaoSocial))
		throw new PessoaException("Pessoa exige uma Razão Social!");
	}
}
