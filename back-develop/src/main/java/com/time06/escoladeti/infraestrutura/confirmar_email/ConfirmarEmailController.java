package com.time06.escoladeti.infraestrutura.confirmar_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.time06.escoladeti.usuario.Usuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/confirmar-email")
public class ConfirmarEmailController {

	@Autowired
	private ConfirmarEmailService service;

	@RequestMapping(method=RequestMethod.GET, value="/{token}")
	@ResponseBody
	public Usuario confirmarEmail(@PathVariable String token) {
		return service.confirmarEmail(token);
	}
	
    @RequestMapping(method = RequestMethod.POST)
    public void enviaEmailComTokenParaRedefinicaoSenha(@RequestBody ReenviarEmailDeConfirmacaoDeEmailCommand command) {
        service.enviaEmailDeConfirmacaoDeCadastro(new EnviarConfirmacaoDeEmailEvent(command.getEmail(), command.getNome()));
    }
}
