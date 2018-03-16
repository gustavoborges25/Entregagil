package com.time06.escoladeti.pessoa.pessoa_fisica;

import static com.time06.escoladeti.infraestrutura.Util.vazio;
import javax.persistence.Entity;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa.PessoaEvent;
import com.time06.escoladeti.pessoa.PessoaException;

@Entity
public class PessoaFisica extends Pessoa{

	private String nome;
	private String sobrenome;
	private String cpf;
	private String rg;
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}
	
	public PessoaFisica(PessoaFisicaEvent event, Endereco endereco) {
		super(new PessoaEvent(event.getCpf(), event.getTipoPessoa(), 
				event.getTelefone(), event.getCelular(), event.getFoto()), endereco);
		
		requerNomeNaoNulo(event.getNome());
		requerSobrenomeNaoNulo(event.getSobrenome());
		requerCpfNaoNulo(event.getCpf());
		requerRgNaoNulo(event.getRg());
		
		this.nome = event.getNome();
		this.sobrenome = event.getSobrenome();
		this.cpf = event.getCpf();
		this.rg = event.getRg();
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
	
	private void requerNomeNaoNulo(String nome) {
		if (vazio(nome))
			throw new PessoaException("Pessoa exige um Nome!");
		
	}

	private void requerSobrenomeNaoNulo(String sobrenome) {
		if (vazio(sobrenome))
			throw new PessoaException("Pessoa exige um Sobrenome!");	
		
	}

	private void requerCpfNaoNulo(String cpf) {
		if (vazio(cpf))
			throw new PessoaException("Pessoa exige um CPF!");
		
	}

	private void requerRgNaoNulo(String rg) {
		if (vazio(rg))
			throw new PessoaException("Pessoa exige um RG!");
		
	}
}
