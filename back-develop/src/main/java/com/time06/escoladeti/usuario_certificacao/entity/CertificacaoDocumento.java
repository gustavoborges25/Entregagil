package com.time06.escoladeti.usuario_certificacao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.usuario_certificacao.command_event.CreateDocumentoEvent;

import javax.persistence.*;

@Entity
@Table(name = "CERTIFICACAO_DOCUMENTO")
public class CertificacaoDocumento extends ModeloBase {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "ARQUIVO")
    private byte[] arquivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO_CERTIFICACAO")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CertificacaoUsuario certificacaoUsuario;

    public CertificacaoDocumento(CreateDocumentoEvent createDocumentoEvent) {
        this.nome = createDocumentoEvent.getNome();
        this.arquivo = createDocumentoEvent.getArquivo();
        this.certificacaoUsuario = createDocumentoEvent.getCertificacaoUsuario();
    }

    protected CertificacaoDocumento() {
    }

    public String getNome() {
        return nome;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public CertificacaoUsuario getCertificacaoUsuario() {
        return certificacaoUsuario;
    }

}