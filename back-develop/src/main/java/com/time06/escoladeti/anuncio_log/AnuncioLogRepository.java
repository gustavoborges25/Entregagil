package com.time06.escoladeti.anuncio_log;

import com.time06.escoladeti.anuncio_log.entity.AnuncioLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnuncioLogRepository extends JpaRepository<AnuncioLog, String> {

    @Query(value =  "SELECT new AnuncioLog(a.data, a.status, a.local) FROM  AnuncioLog  a WHERE a.anuncio.id = ?1 ORDER BY data DESC")
    List<AnuncioLog> findByAnuncioId(String idAnuncio);

}
