package com.time06.escoladeti.usuario_certificacao.command_event;

import com.time06.escoladeti.infraestrutura.Util;
import com.time06.escoladeti.usuario_certificacao.CertificacaoUsuarioException;
import com.time06.escoladeti.usuario_certificacao.entity.CertificacaoUsuario;
import org.apache.commons.codec.binary.Base64;

public class CreateDocumentoEvent {

    private String nome;
    private byte[] arquivo;
    private CertificacaoUsuario certificacaoUsuario;

    public CreateDocumentoEvent(String nome, String arquivo, CertificacaoUsuario certificacaoUsuario) {
        if (Util.vazio(nome)) {
            throw new CertificacaoUsuarioException("Nome do documento não pode ser vazio.");
        }
        if (Util.vazio(arquivo)) {
            throw new CertificacaoUsuarioException("Documento não pode ser vazio.");
        }
        if (certificacaoUsuario == null) {
            throw new CertificacaoUsuarioException("Certificado não encontrado.");
        }
        this.nome = nome;
        this.arquivo = Base64.decodeBase64(arquivo);
        this.certificacaoUsuario = certificacaoUsuario;
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