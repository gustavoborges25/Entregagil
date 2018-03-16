package com.time06.escoladeti.anuncio_lance;

import com.time06.escoladeti.anuncio_lance.entity.AnuncioLance;
import com.time06.escoladeti.anuncio_lance.entity.AnuncioLanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioLanceRepository extends JpaRepository<AnuncioLance, String> {

    @Query(value = "SELECT new AnuncioLance(a.id, a.transportador, a.dataCadastro, a.estimativa, a.cargaFracionada, a.observacoes, a.status, a.valor) FROM AnuncioLance a WHERE a.anuncio.id = ?1")
    List<AnuncioLance> findByAnuncioId(String idAnuncio);

    @Query("SELECT COUNT(id) FROM AnuncioLance WHERE id = ?1 AND status = ?2")
    Long lanceComStatus(String idLance, AnuncioLanceStatus anuncioLanceStatus);

    @Modifying
    @Query(value="UPDATE AnuncioLance SET status = ?2 WHERE id = ?1")
    void updateStatusLance(String id, AnuncioLanceStatus anuncioLanceStatus);

    AnuncioLance findTop1ByAnuncioIdOrderByValorAsc(String idAnuncio);

    List<AnuncioLance> findByTransportadorId(String idTransportador);

}
