package com.time06.escoladeti.endereco;

import javax.persistence.Entity;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.infraestrutura.Util;

import java.util.UUID;

@Entity
public class Endereco extends ModeloBase {

	private String cep;
	private String endereco;
	private String numero;
	private String bairro;
	private String tipoEndereco;
	private String complemento;
	private String cidade;
	private String estado;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(CriarEnderecoEvent event) {
		super();
		
		requerCepNaoNulo(event.getCep());
		requerEnderecoNaoNulo(event.getEndereco());
		requerNumeroNaoNulo(event.getNumero());
		requerCidadeNaoNula(event.getCidade());
		requerEstadoNaoNulo(event.getEstado());
		requerTipoEnderecoNaoNulo(event.getTipoEndereco());

		if (Util.vazio(event.getId())) {
			this.id = UUID.randomUUID().toString();
		} else {
			this.id = event.getId();
		}
		
		this.cep = event.getCep();
		this.endereco = event.getEndereco();
		this.numero = event.getNumero();
		this.bairro = event.getBairro();
		this.tipoEndereco = event.getTipoEndereco();
		this.complemento = event.getComplemento();
		this.cidade = event.getCidade();
		this.estado = event.getEstado();

		requerIdNaoNulo(this.id);
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
		return "Brasil";
	}
	
	public String getTipoEndereco() {
		return tipoEndereco;
	}

	private void requerTipoEnderecoNaoNulo(String tipoEndereco) {
		if (tipoEndereco == null || tipoEndereco.isEmpty())
			throw new EnderecoException("Campo Tipo Endereço obrigatório!");
		
	}

	private void requerEstadoNaoNulo(String estado) {
		if (estado == null || estado.isEmpty())
			throw new EnderecoException("Campo Estado obrigatório!");
	}

	private void requerCidadeNaoNula(String cidade) {
		if (cidade == null || cidade.isEmpty())
			throw new EnderecoException("Campo Cidade obrigatório!");
	}

	private void requerNumeroNaoNulo(String numero) {
		if (numero == null || numero.isEmpty())
			throw new EnderecoException("Campo Número obrigatório!");
	}

	private void requerEnderecoNaoNulo(String endereco) {
		if (endereco == null || endereco.isEmpty())
			throw new EnderecoException("Campo Endereco obrigatório!");
	}

	private void requerCepNaoNulo(String cep) {
		if (cep == null || cep.isEmpty())
			throw new EnderecoException("Campo CEP obrigatório!");
	}

	private void requerIdNaoNulo(String id) {
		if (id == null || id.isEmpty())
			throw new EnderecoException("Endereço exige um ID!");
	}
}
