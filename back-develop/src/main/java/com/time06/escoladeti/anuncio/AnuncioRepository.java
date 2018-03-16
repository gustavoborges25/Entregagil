package com.time06.escoladeti.anuncio;

import com.time06.escoladeti.anuncio.entity.Anuncio;
import com.time06.escoladeti.anuncio.entity.AnuncioSituacao;
import com.time06.escoladeti.anuncio.type.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, String> {

    List<Anuncio> findByCategoria(TipoCategoria categoria);

    @Query(value = "select distinct a.* " +
            "from anuncio a " +
            "join anuncio_item ai on ai.id_anuncio = a.id " +
            "join pessoa p on p.id = a.id_pessoa " +
            "join endereco e1 on e1.id = a.id_endereco_origem " +
            "join endereco e2 on e2.id = a.id_endereco_destino " +
            "where a.b_titulo @@ plainto_tsquery(simples(:query)) " +
            "or p.b_nome @@ plainto_tsquery(simples(:query)) " +
            "or p.b_sobrenome @@ plainto_tsquery(simples(:query)) " +
            "or p.b_nome || p.b_sobrenome @@ plainto_tsquery(simples(:query)) " +
            "or e1.b_cidade @@ plainto_tsquery(simples(:query)) " +
            "or e1.estado like %:query% " +
            "or e2.b_cidade @@ plainto_tsquery(simples(:query)) " +
            "or e2.estado like %:query% "
            , nativeQuery = true)
    List<Anuncio> pesquisarAnunciosPorQuery(@Param("query") String query);

    @Modifying
    @Query(value = "UPDATE pessoa SET b_nome = to_tsvector(simples(nome)); UPDATE pessoa SET b_sobrenome = to_tsvector(simples(sobrenome)); UPDATE endereco SET b_cidade = to_tsvector(simples(cidade)); UPDATE anuncio SET b_contato_origem = to_tsvector(simples(contato_origem)); UPDATE anuncio SET b_contato_destino = to_tsvector(simples(contato_destino)); UPDATE anuncio_item SET b_observacao = to_tsvector(simples(observacao)); UPDATE anuncio SET b_titulo = to_tsvector(simples(titulo));", nativeQuery = true)
    void normalizaDadosParaPesquisa();

    @Query(value = "SELECT count(*) FROM anuncio WHERE id_pessoa = :idAnunciante", nativeQuery = true)
    Integer getQuantidadeAnunciosCadastradosPeloAnunciante(@Param("idAnunciante") String idAnunciante);

    List<Anuncio> findByAnuncianteIdAndSituacaoNot(String idPessoa, AnuncioSituacao situacao);

    List<Anuncio> findByTransportadorIdAndSituacaoNot(String idPessoa, AnuncioSituacao situacao);

    List<Anuncio> findTop12ByOrderByDataCadastroDesc();

}