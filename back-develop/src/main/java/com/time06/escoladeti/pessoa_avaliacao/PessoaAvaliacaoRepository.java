package com.time06.escoladeti.pessoa_avaliacao;

import com.time06.escoladeti.pessoa_avaliacao.entity.AvaliadoComo;
import com.time06.escoladeti.pessoa_avaliacao.entity.PessoaAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaAvaliacaoRepository extends JpaRepository<PessoaAvaliacao, String> {

    List<PessoaAvaliacao> findByAvaliadorId(String idAvaliador);

    List<PessoaAvaliacao> findByAvaliadoIdAndAvaliadoAvaliadoComo(String idAvaliado, AvaliadoComo avaliadoAvaliadoComo);

    PessoaAvaliacao findById(String id);

}