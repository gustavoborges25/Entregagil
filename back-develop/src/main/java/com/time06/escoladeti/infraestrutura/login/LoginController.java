package com.time06.escoladeti.infraestrutura.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(method = RequestMethod.POST)
    public Token logar(@RequestBody LogarCommand command) {
        return service.logar(command);
    }

}