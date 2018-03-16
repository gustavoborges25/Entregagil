package com.time06.escoladeti.usuario_certificacao;

import com.time06.escoladeti.usuario_certificacao.entity.CertificacaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CertificacaoUsuarioRepository extends JpaRepository<CertificacaoUsuario, String> {

    @Query("SELECT COUNT(u) FROM CertificacaoUsuario u WHERE u.usuario.id = ?1 AND u.pagamentoConfirmado = true")
    Long getCountCertificacaoPagaUsuario(String idUsuario);

    CertificacaoUsuario findByUsuarioId(String idUsuario);

    @Modifying
    @Query(value = "UPDATE CertificacaoUsuario u SET u.pagamentoConfirmado = true WHERE u.usuario.id = ?1")
    void receberPagamento(String idUsuario);

}