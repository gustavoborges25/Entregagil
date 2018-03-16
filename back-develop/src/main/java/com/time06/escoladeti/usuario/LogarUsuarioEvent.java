package com.time06.escoladeti.usuario;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.time06.escoladeti.infraestrutura.criptografia.CriptografarSenha;

public class LogarUsuarioEvent {

	@NotNull (message = "Usuário exige um Email.")
	@NotEmpty
    private String email;
	@NotNull (message = "Usuário exige uma Senha.")
	@NotEmpty
    private String senha;

    public LogarUsuarioEvent(String email, String senha) {
        this.email = email;
        this.senha = CriptografarSenha.gerarSenhaCriptografada(senha);
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}