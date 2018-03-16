package com.time06.escoladeti.usuario;

import com.time06.escoladeti.endereco.CriarEnderecoEvent;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.endereco.EnderecoService;
import com.time06.escoladeti.infraestrutura.confirmar_email.EnviarConfirmacaoDeEmailEvent;
import com.time06.escoladeti.infraestrutura.confirmar_email.ConfirmarEmailService;
import com.time06.escoladeti.infraestrutura.criptografia.CriptografarSenha;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa.PessoaService;
import com.time06.escoladeti.pessoa.pessoa_fisica.PessoaFisica;
import com.time06.escoladeti.pessoa.pessoa_fisica.PessoaFisicaEvent;
import com.time06.escoladeti.pessoa.pessoa_juridica.PessoaJuridica;
import com.time06.escoladeti.pessoa.pessoa_juridica.PessoaJuridicaEvent;
import com.time06.escoladeti.usuario.alterar_usuario.EnviarTokenAlteracaoEmailEvent;
import com.time06.escoladeti.usuario.alterar_usuario.SolicitarAlteracaoEmailCommand;
import com.time06.escoladeti.usuario.alterar_usuario.TokenAlterarEmailService;
import com.time06.escoladeti.usuario.alterar_usuario.UpdateEmailUsuarioCommand;
import com.time06.escoladeti.usuario.alterar_usuario.UpdateSenhaUsuarioCommand;
import com.time06.escoladeti.usuario.alterar_usuario.UpdateEmailUsuarioException;

import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UsuarioService  {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private ConfirmarEmailService confirmarEmailService;
	
    @Autowired
    private TokenAlterarEmailService alteracaoEmailService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private EnderecoService enderecoService;

	@Transactional(rollbackFor = Exception.class)
	public void create(CreateUsuarioCommand command) {
		validaEmailDuplicado(command.getEmail());

		command.setSenha(CriptografarSenha.gerarSenhaCriptografada(command.getSenha()));

		Endereco endereco = new Endereco(new CriarEnderecoEvent("",
				command.getCep(),
				command.getEndereco(),
				command.getNumero(),
				command.getBairro(),
				command.getTipoEndereco(),
				command.getComplemento(),
				command.getCidade(),
				command.getEstado()));
		
		Pessoa pessoa = command.getTipoPessoa().equals("fisica") ?
						new PessoaFisica(
										new PessoaFisicaEvent (
												"",
												command.getNome(),
												command.getSobrenome(),
												command.getCpf(),
												command.getRg(),
												command.getTipoPessoa(),
												command.getTelefone(),
												command.getCelular(),
												command.getFoto()), endereco)
				
					:	new PessoaJuridica(
										new PessoaJuridicaEvent(
												"",
												command.getRazaoSocial(),
												command.getFantasia(),
												command.getCnpj(),
												command.getInscricaoEstadual(),
												command.getTipoPessoa(),
												command.getTelefone(),
												command.getCelular(),
												command.getFoto()), endereco);
										
		Usuario usuario = new Usuario(new CreateUsuarioEvent(
				command.getEmail(),
				command.getSenha()),
				pessoa);
				
		repository.save(usuario);
		
		confirmarEmailService.enviaEmailDeConfirmacaoDeCadastro(new EnviarConfirmacaoDeEmailEvent(command.getEmail(),
													 command.getNome() == null ? command.getRazaoSocial() :
													 command.getNome()));
	}

	private void validaEmailDuplicado(String email) {
		if (repository.findByEmail(email) != null) {
			throw new EmailDuplicadoException();
		}
	}

	@Transactional
	public Usuario update(@RequestBody UpdateUsuarioCommand command) {
		pessoaService.atualizaTelefoneECelular(command.getTelefone(), command.getCelular(), command.getIdPessoa());
		Endereco endereco = new Endereco(new CriarEnderecoEvent(
				command.getEndereco().getId(),
				command.getEndereco().getCep(),
				command.getEndereco().getEndereco(),
				command.getEndereco().getNumero(),
				command.getEndereco().getBairro(),
				command.getEndereco().getTipoEndereco(),
				command.getEndereco().getComplemento(),
				command.getEndereco().getCidade(),
				command.getEndereco().getEstado()));
		enderecoService.update(endereco);
		return repository.findOne(command.getIdUsuario());
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateSenha(UpdateSenhaUsuarioCommand command) {
		command.setSenha(CriptografarSenha.gerarSenhaCriptografada(command.getSenha()));
		
		Usuario usuario = repository.findOne(command.getId());
		
		if (usuario == null)
			throw new UsuarioException("Usuário não encontrado");
		
		if (command.getSenha() == null || command.getSenha().length() < 6)
			throw new UsuarioSenhaInvalidaException();
		
		repository.atualizaSenha(command.getId(), command.getSenha());
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void updateEmail(UpdateEmailUsuarioCommand command) {
		Usuario usuario = repository.findOne(command.getId());
		
		if (usuario == null)
			throw new UsuarioException("Usuário não encontrado");
		
		if (command.getNovoEmail() == null) 
			throw new UpdateEmailUsuarioException();
		
		repository.atualizaEmail(command.getId(), command.getNovoEmail());
		alteracaoEmailService.delete(command.getToken());
		confirmarEmailService.enviaEmailDeConfirmacaoDeCadastro(new EnviarConfirmacaoDeEmailEvent(command.getNovoEmail(), 
														 								command.getNome()));
	}

	public void solicitarAlteracaoEmail(SolicitarAlteracaoEmailCommand command) {
		Usuario usuario = repository.findOne(command.getIdUsuario());
		
		if (usuario == null)
			throw new UsuarioException("Usuário não encontrado");
		
		alteracaoEmailService.enviarLinkParaAlteracaoDeEmail(new EnviarTokenAlteracaoEmailEvent(usuario.getId(),
																	    usuario.getEmail(), command.getNome()));
	}
	
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findOne(String id) {
		return repository.findOne(id);
	}

	public void delete(String id) {
		repository.delete(id);
	}

	@Transactional
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Transactional
	public List<Usuario> findByEmailAndSenha(Usuario usuario) {
		return repository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
	}

	public void atualizarSenhaUsuario(Usuario usuario, String novaSenha) {
		repository.atualizaSenha(usuario.getId(), CriptografarSenha.gerarSenhaCriptografada(novaSenha));
	}
	
	public void atualizarCampoEmailConfirmado(String idUsuario) {
		repository.atualizaEmailConfirmado(idUsuario);
	}

	public void atualizarEmailUsuario(Usuario usuario, String email) {
		repository.atualizaEmail(usuario.getId(), email);
	}

	public Usuario getUsuarioByToken(String tokenUsuarioAceitandoLance) {
		return repository.getUsuarioByToken(tokenUsuarioAceitandoLance);
	}
}