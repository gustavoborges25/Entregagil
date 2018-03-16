package com.time06.escoladeti.infraestrutura.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Token, String> {

    List<Token> findByUsuarioId(String idUsuario);

    List<Token> findByToken(String token);

}