package com.time06.escoladeti.pessoa;

import com.time06.escoladeti.endereco.CriarEnderecoEvent;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.endereco.EnderecoException;
import com.time06.escoladeti.endereco.EnderecoService;
import com.time06.escoladeti.infraestrutura.Tipos.tipoPessoa;
import com.time06.escoladeti.pessoa.pessoa_fisica.PessoaFisica;
import com.time06.escoladeti.pessoa.pessoa_fisica.PessoaFisicaEvent;
import com.time06.escoladeti.pessoa.pessoa_juridica.PessoaJuridica;
import com.time06.escoladeti.pessoa.pessoa_juridica.PessoaJuridicaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	@Autowired
	private EnderecoService enderecoService;

	@Transactional(rollbackFor = Exception.class)
	public Pessoa update(AlterarPessoaCommand command) {
				
		if(command.getEndereco().getId() == null)
			throw new EnderecoException("Para alterar uma Pessoa, é preciso passar um Endereço.");

		atualizaTelefoneECelular(command.getTelefone(), command.getCelular(), command.getId());
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

		Pessoa pessoa = repository.findOne(command.getId());
		pessoa.setFoto(command.getFoto());
		repository.save(pessoa);

		return pessoa;
	}
	
	public Pessoa newPessoa(PessoaCommand command) {
		Endereco endereco = new Endereco(new CriarEnderecoEvent("",
				command.getCep(),
				command.getEndereco(),
				command.getNumero(),
				command.getBairro(),
				command.getTipoEndereco(),
				command.getComplemento(),
				command.getCidade(),
				command.getEstado()));
		
		Pessoa pessoa = tipoPessoa.fisica.toString() == "fisica" ?
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
								
	    return pessoa;
	}

	public List<Pessoa> findAll() {
		
		return repository.findAll();
	}

	public Pessoa findOne(String id) {
		if (id == null) { throw new PessoaException("Pessoa com ID vazio não encontrada! Informe um ID."); }
		return repository.findOne(id);
	}

	public void atualizaTelefoneECelular(String telefone, String celular, String id) {
		repository.atualizaTelefoneECelular(telefone,celular,id);
	}

}