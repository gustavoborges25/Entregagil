package com.time06.escoladeti.pessoa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pessoa> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Pessoa update(@RequestBody AlterarPessoaCommand command) {
		return service.update(command);
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Pessoa getPessoa(@PathVariable String id) {
		return service.findOne(id);
	}
}

