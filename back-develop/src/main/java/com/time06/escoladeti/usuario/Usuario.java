package com.time06.escoladeti.usuario;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa.pessoa_fisica.PessoaFisica;
import com.time06.escoladeti.pessoa.pessoa_juridica.PessoaJuridica;
import com.time06.escoladeti.usuario.alterar_usuario.UpdateUsuarioEvent;
import static com.time06.escoladeti.infraestrutura.Util.vazio;

@Entity
public class Usuario extends ModeloBase {
	
	@NotNull (message = "Usuário exige um Email.")
	@NotEmpty
	private String email;
	
	@NotNull
	@Size(min = 6)
	@JsonIgnore
	private String senha;
		
	@NotNull (message = "Usuário exige uma Pessoa.")
	@ManyToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;
	
	private Boolean emailConfirmado;
	private Boolean ativo;
	private Boolean usuarioCertificado;

	protected Usuario() {
	}

	public Usuario(LogarUsuarioEvent logarUsuarioEvent) {
		this.email = logarUsuarioEvent.getEmail();
		this.senha = logarUsuarioEvent.getSenha();
	}
		
	public Usuario(CreateUsuarioEvent event, Pessoa pessoa) {
		super();
		
		if(id == null || id.isEmpty())
			this.id = event.getId();
		
		requerIdNaoNulo(id);
		requerEmailNaoNulo(event.getEmail());
		requerSenhaNaoNula(event.getSenha());
		requerPessoaNaoNula(pessoa);
			
		this.email = event.getEmail();
		this.senha = event.getSenha();
		this.emailConfirmado = false;
		this.usuarioCertificado = false;
		this.pessoa = pessoa;
	}
	
	public Usuario(UpdateUsuarioEvent event) {
		
		requerIdNaoNulo(event.getId());
		requerEmailNaoNulo(event.getEmail());
		requerSenhaNaoNula(event.getSenha());
			
		this.id = event.getId();
		this.email = event.getEmail();
		this.senha = event.getSenha();
		this.emailConfirmado = event.getEmailConfirmado();
		this.usuarioCertificado = false;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Boolean getEmailConfirmado() {
		return emailConfirmado;
	}

	public Boolean getUsuarioCertificado() {
		return usuarioCertificado;
	}

	private void requerEmailNaoNulo(String email) {
		if (vazio(email))
		throw new UsuarioException("Usuário exige um Email!");
	}
	
	private void requerSenhaNaoNula(String senha) {
		if (vazio(senha))
			throw new UsuarioException("Usuário exige uma Senha!");
	}

	private void requerIdNaoNulo(String id) {
		if (vazio(id))
			throw new UsuarioException("Usuário não pode ter ID nulo!");
	}
	
	private void requerPessoaNaoNula(Pessoa pessoa) {
		if (pessoa == null)
			throw new UsuarioException("Usuário exige uma Pessoa!");
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setEmailConfirmado() {
		this.emailConfirmado = true;
	}
}
