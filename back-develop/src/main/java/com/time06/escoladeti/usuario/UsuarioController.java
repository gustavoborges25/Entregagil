package com.time06.escoladeti.usuario;

import static com.time06.escoladeti.infraestrutura.validador_token_usuario.LoginConstantes.TOKEN_USUARIO;
import java.util.List;
import com.time06.escoladeti.infraestrutura.validador_token_usuario.ValidarUsuarioAutenticado;
import com.time06.escoladeti.usuario.alterar_usuario.SolicitarAlteracaoEmailCommand;
import com.time06.escoladeti.usuario.alterar_usuario.SolicitarAlteracaoEmailException;
import com.time06.escoladeti.usuario.alterar_usuario.TokenAlterarEmailService;
import com.time06.escoladeti.usuario.alterar_usuario.UpdateEmailUsuarioCommand;
import com.time06.escoladeti.usuario.alterar_usuario.UpdateSenhaUsuarioCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@Autowired
	private TokenAlterarEmailService tokenAlterarEmailservice;

	@RequestMapping(method = RequestMethod.POST, value="/cadastrar-usuario")
	public void create(@RequestBody CreateUsuarioCommand command) {
		service.create(command);
	}

	@Transactional
	@ValidarUsuarioAutenticado
	@RequestMapping(method = RequestMethod.PUT)
	public Usuario update(@RequestBody UpdateUsuarioCommand command) {
		return service.update(command);
	}

	@ValidarUsuarioAutenticado
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> findAll(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario) {
		return service.findAll();
	}
	
	@ValidarUsuarioAutenticado
	@RequestMapping(method=RequestMethod.PUT, value="/alterar-senha")
	public void updateSenha(@RequestBody UpdateSenhaUsuarioCommand command) {
		service.updateSenha(command);
	}

	@ValidarUsuarioAutenticado
	@RequestMapping(method=RequestMethod.PUT, value="/alterar-email")
	public void updateEmail(@RequestBody UpdateEmailUsuarioCommand command) {
		service.updateEmail(command);
	}
	
	@ValidarUsuarioAutenticado
	@RequestMapping(method=RequestMethod.PUT, value="/solicitar-alteracao-email")
	public void solicitarAlteracaoEmail(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, 
			@RequestBody SolicitarAlteracaoEmailCommand command) 
		throws SolicitarAlteracaoEmailException {
		service.solicitarAlteracaoEmail(command);
	}

	@ValidarUsuarioAutenticado
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delete(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String id) {
		service.delete(id);
	}

	@ValidarUsuarioAutenticado
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Usuario findOne(@RequestHeader(value = TOKEN_USUARIO) String tokenUsuario, @PathVariable String id) {
		return service.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/alterar-email/{token}")
    public Usuario autenticaAlteracaoEmail(@PathVariable String token) {
        return tokenAlterarEmailservice.getUsuarioAssociadoAoTokenDeAteracaoDeEmail(token);
    }
}

