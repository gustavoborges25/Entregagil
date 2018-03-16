package com.time06.escoladeti.infraestrutura.redefinir_senha;

import com.time06.escoladeti.usuario.Usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class TokenRedefinicaoSenha implements Serializable {

    @Id
    private String token;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public TokenRedefinicaoSenha(Usuario usuario) {
        this.usuario = usuario;
        this.token = UUID.randomUUID().toString();
    }

    protected TokenRedefinicaoSenha() {
    }

    public String getToken() {
        return token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}