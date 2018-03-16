package com.time06.escoladeti.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, String>{

    @Modifying
    @Query(value="UPDATE pessoa SET telefone = ?1, celular = ?2 WHERE id = ?3", nativeQuery = true)
    void atualizaTelefoneECelular(String telefone, String celular, String id);

}