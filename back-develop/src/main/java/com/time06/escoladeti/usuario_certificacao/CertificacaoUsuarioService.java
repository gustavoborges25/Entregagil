package com.time06.escoladeti.usuario_certificacao;

import com.time06.escoladeti.usuario.Usuario;
import com.time06.escoladeti.usuario.UsuarioService;
import com.time06.escoladeti.usuario_certificacao.command_event.CreateDocumentoCommand;
import com.time06.escoladeti.usuario_certificacao.command_event.CreateDocumentoEvent;
import com.time06.escoladeti.usuario_certificacao.entity.CertificacaoDocumento;
import com.time06.escoladeti.usuario_certificacao.entity.CertificacaoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CertificacaoUsuarioService {

    @Autowired
    private CertificacaoUsuarioRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    public CertificacaoUsuario criaCertificacao(String idUsuario, Boolean proprietario) {
        Usuario usuario = usuarioService.findOne(idUsuario);
        if (usuario == null) {
            throw new CertificacaoUsuarioException("Usuário não encontrado.");

        }
        CertificacaoUsuario certificacaoUsuario = CertificacaoUsuario.create(usuario, proprietario);
        return repository.save(certificacaoUsuario);
    }

    public void addDocumento(String idCertificacao, CreateDocumentoCommand createDocumentoCommand) {
        CertificacaoUsuario certificacaoUsuario = repository.getOne(idCertificacao);

        CertificacaoDocumento certificacaoDocumento =
                new CertificacaoDocumento(
                        new CreateDocumentoEvent(createDocumentoCommand.getNome(), createDocumentoCommand.getArquivo(), certificacaoUsuario));

        certificacaoUsuario.addDocumento(certificacaoDocumento);
        repository.save(certificacaoUsuario);
    }

    public Boolean usuarioPossuiCertificacaoPago(String idUsuario) {
        return repository.getCountCertificacaoPagaUsuario(idUsuario) > 0;
    }

    @Transactional
    public CertificacaoUsuario getCertificacaoUsuario(String idUsuario) {
        return repository.findByUsuarioId(idUsuario);
    }

    @Transactional
    public void receberPagamento(String idUsuario) {
        repository.receberPagamento(idUsuario);
    }

}