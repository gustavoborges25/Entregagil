package com.time06.escoladeti.infraestrutura.redefinir_senha;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RedefinirSenhaRepository extends JpaRepository<TokenRedefinicaoSenha, String> {

    List<TokenRedefinicaoSenha> findByUsuarioId(String idUsuario);

}