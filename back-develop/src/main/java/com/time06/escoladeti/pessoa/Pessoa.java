package com.time06.escoladeti.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.endereco.EnderecoException;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.pessoa.pessoa_fisica.PessoaFisica;
import com.time06.escoladeti.pessoa.pessoa_juridica.PessoaJuridica;
import com.time06.escoladeti.usuario.Usuario;

import javax.persistence.*;
import static com.time06.escoladeti.infraestrutura.Util.vazio;

import java.util.HashSet;
import java.util.List;

import static com.time06.escoladeti.infraestrutura.Util.saveImage;

@Entity
public abstract class Pessoa extends ModeloBase {
	
	private String tipoPessoa;
	
	private String telefone;
	
	private String celular;
	
	private String foto;

	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="pessoa_id")
	private List<Usuario> usuario;

	protected Pessoa() {
	}
	
	public Pessoa(PessoaEvent event, Endereco endereco) {
	
		requerTipoPessoaNaoNula(event.getTipoPessoa());
		requerPeloUmTelefoneNaoNulo(event.getTelefone(), event.getCelular());
		
		requerEnderecoNaonulo(endereco);
		requerFotoNaoNula(event.getFoto());
		
		if(id == null || id.isEmpty())
			this.id = event.getId();
			
		requerIdNaoNulo(id);
		
		this.tipoPessoa = event.getTipoPessoa();
		this.telefone = event.getTelefone();
		this.celular = event.getCelular();
		this.foto = saveImage(event.getFoto());
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public String getCelular() {
		return celular;
	}
	
	
	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	private void requerIdNaoNulo(String id) {
		if (id == null || id.isEmpty())
			throw new PessoaException("Pessoa não pode ter ID nulo!");
	}
	
	private void requerFotoNaoNula(String foto) {
		if (vazio(foto))
			throw new PessoaException("Pessoa exige uma Foto!");	
	}

	private void requerPeloUmTelefoneNaoNulo(String telefone, String celular) {
		if (vazio(telefone) && vazio(celular))
			throw new PessoaException("Pessoa exige pelo menos um Telefone!");	
	}

	private void requerTipoPessoaNaoNula(String tipoPessoa) {
		if (vazio(tipoPessoa))
			throw new PessoaException("Pessoa exige um Tipo Pessoa(Jurídica ou Física)!");
	}
		
	private void requerEnderecoNaonulo(Endereco endereco) {
		if (endereco == null)
			throw new EnderecoException("Pessoa exige um Endereço!");
	}

	public void setFoto(String foto) {
		String caminho = saveImage(foto);
		this.foto = caminho;
	}

	public String getNome() {
		if ("fisica".equalsIgnoreCase(tipoPessoa)) {
			return ((PessoaFisica) this).getNome();
		} else {
			return ((PessoaJuridica) this).getFantasia();
		}
	}
}
