package com.time06.escoladeti.usuario.alterar_usuario;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenAlterarEmailRepository extends
	JpaRepository<TokenAlterarEmail, String> {

	 TokenAlterarEmail findByUsuarioId(String idUsuario);

	@Transactional
    @Modifying
    @Query(value="delete from token_alterar_email where token = ?1",
    		nativeQuery=true) 
    void deleteToken(String token);
}
