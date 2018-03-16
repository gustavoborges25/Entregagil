package com.time06.escoladeti.anuncio_pergunta;

import com.time06.escoladeti.anuncio_pergunta.entity.AnuncioPergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioPerguntaRepository extends JpaRepository<AnuncioPergunta, String> {

    List<AnuncioPergunta> findByAnuncioIdOrderByDataCadastroDesc(String idAnuncio);

}