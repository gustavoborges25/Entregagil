package com.time06.escoladeti.usuario_certificacao.entity;

import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.usuario.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CERTIFICACAO_USUARIO")
public class CertificacaoUsuario extends ModeloBase {

    @OneToOne
    private Usuario usuario;

    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "ID_USUARIO_CERTIFICACAO")
    private List<CertificacaoDocumento> certificacaoDocumentos;

    @Column(name = "BO_PAGAMENTO_EFETUADO")
    private Boolean pagamentoConfirmado;

    @Column(name = "BO_PROPRIETARIO_VEICULO")
    private Boolean proprietarioDoVeiculo;

    protected CertificacaoUsuario() {
    }

    protected CertificacaoUsuario(Usuario usuario, Boolean proprietario) {
        this.certificacaoDocumentos = new ArrayList<>();
        this.pagamentoConfirmado = false;
        this.proprietarioDoVeiculo = proprietario;
        this.usuario = usuario;
    }

    public static CertificacaoUsuario create(Usuario usuario, Boolean proprietario) {
        return new CertificacaoUsuario(usuario ,proprietario);
    }

    public void addDocumento(CertificacaoDocumento certificacaoDocumento) {
        if (certificacaoDocumentos == null) {
            certificacaoDocumentos = new ArrayList<>();
        }
        certificacaoDocumentos.add(certificacaoDocumento);
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public List<CertificacaoDocumento> getCertificacaoDocumentos() {
        return certificacaoDocumentos;
    }

    public Boolean getPagamentoConfirmado() {
        return pagamentoConfirmado;
    }

    public Boolean getProprietarioDoVeiculo() {
        return proprietarioDoVeiculo;
    }

}