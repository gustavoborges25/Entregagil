package com.time06.escoladeti.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	Usuario findByEmail(String email);
	
	List<Usuario> findByEmailAndSenha(String email, String senha);

    @Modifying
    @Query(value="update Usuario set senha = ?2 where id = ?1",
    		nativeQuery=true)
    void atualizaSenha(String idUsuario, String novaSenha);
    
    @Transactional
    @Modifying
    @Query(value="update Usuario set email_confirmado = true where id = ?1",
    		nativeQuery=true) 
    void atualizaEmailConfirmado(String idUsuario);
     
    @Query(value="select id, email, email_confirmado, usuario_certificado, dataCadastro, pessoa_id from Usuario",
    		nativeQuery=true) 
    List<Usuario> findAllUsuario();

    @Transactional
    @Modifying
    @Query(value="update Usuario set email = ?2 where id = ?1",
    		nativeQuery=true) 
	void atualizaEmail(String id, String novoEmail);

    @Query(value = "select * from usuario where id in (select usuario_id from token where token = ?1)", nativeQuery = true)
    Usuario getUsuarioByToken(String tokenUsuarioAceitandoLance);
}