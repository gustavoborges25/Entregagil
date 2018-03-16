package com.time06.escoladeti.infraestrutura.login;

import com.time06.escoladeti.usuario.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Token implements Serializable {

    @Id
    private String token;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Token(Usuario usuario) {
        this.usuario = usuario;
        this.token = UUID.randomUUID().toString();
    }

    protected Token() {
    }

    public String getToken() {
        return token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}