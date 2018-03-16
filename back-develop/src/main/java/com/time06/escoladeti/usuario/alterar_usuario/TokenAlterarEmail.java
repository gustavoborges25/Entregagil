package com.time06.escoladeti.usuario.alterar_usuario;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.time06.escoladeti.usuario.Usuario;

@Entity
public class TokenAlterarEmail {

	@Id
    private String token;

	@OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public TokenAlterarEmail(Usuario usuario) {
        this.usuario = usuario;
        this.token = UUID.randomUUID().toString();
    }

    protected TokenAlterarEmail() {
    }

    public String getToken() {
        return token;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

