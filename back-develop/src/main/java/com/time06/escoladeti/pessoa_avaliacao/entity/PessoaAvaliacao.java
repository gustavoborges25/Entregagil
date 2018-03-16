package com.time06.escoladeti.pessoa_avaliacao.entity;

import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.pessoa.Pessoa;
import com.time06.escoladeti.pessoa_avaliacao.AvaliarUsuarioException;

import javax.persistence.*;

@Entity
public class PessoaAvaliacao extends ModeloBase {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa_avaliador",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Pessoa avaliador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa_avaliado",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Pessoa avaliado;

    @Column(name = "avaliado_avaliado_como")
    @Enumerated(EnumType.STRING)
    private AvaliadoComo avaliadoAvaliadoComo;

    @Column(name = "avaliacao_geral", nullable = false)
    private Integer avaliacaoGeral;

    @Column(name = "bo_recomenda", nullable = false)
    private Boolean recomenda;

    @Column(name = "tempo_entrega")
    private Integer tempoDeEntrega;

    @Column(name = "integridade_mercadoria")
    private Integer integridadeMercadoria;

    @Column(name = "ds_comentario", nullable = false)
    private String comentario;

    protected PessoaAvaliacao() {
    }

    public PessoaAvaliacao(Pessoa avaliador, Pessoa avaliado, AvaliadoComo avaliadoAvaliadoComo, Integer avaliacaoGeral, Boolean recomenda, Integer tempoDeEntrega, Integer integridadeMercadoria, String comentario) {
        validaPreenchimentoDosCamposTransportador(avaliador, avaliado, avaliacaoGeral, recomenda, comentario, tempoDeEntrega, integridadeMercadoria);
        validaAvaliacaoGeral(avaliacaoGeral);
        validaTempoDeEntrega(tempoDeEntrega);
        validaIntegridadeMercadoria(integridadeMercadoria);

        this.avaliador = avaliador;
        this.avaliado = avaliado;
        this.avaliadoAvaliadoComo = avaliadoAvaliadoComo;
        this.avaliacaoGeral = avaliacaoGeral;
        this.recomenda = recomenda;
        this.tempoDeEntrega = tempoDeEntrega;
        this.integridadeMercadoria = integridadeMercadoria;
        this.comentario = comentario;
    }

    public PessoaAvaliacao(Pessoa avaliador, Pessoa avaliado, AvaliadoComo avaliadoAvaliadoComo, Integer avaliacaoGeral, Boolean recomenda, String comentario) {
        validaPreenchimentoDosCamposAnunciante(avaliador, avaliado, avaliacaoGeral, recomenda, comentario);
        validaAvaliacaoGeral(avaliacaoGeral);

        this.avaliador = avaliador;
        this.avaliado = avaliado;
        this.avaliadoAvaliadoComo = avaliadoAvaliadoComo;
        this.avaliacaoGeral = avaliacaoGeral;
        this.recomenda = recomenda;
        this.comentario = comentario;
    }

    private void validaPreenchimentoDosCamposAnunciante(Pessoa avaliador, Pessoa avaliado, Integer avaliacaoGeral, Boolean recomenda, String comentario) {
        if (avaliador == null) { throw new AvaliarUsuarioException("Avalidor não encontrado."); }
        if (avaliado == null) { throw new AvaliarUsuarioException("Avaliado não encontrado."); }
        if (avaliacaoGeral == null) { throw new AvaliarUsuarioException("Deve ser informada a Avaliação Geral."); }
        if (recomenda == null) { throw new AvaliarUsuarioException("Deve ser informado se recomenda ou não o anunciante."); }
        if (comentario == null) { throw new AvaliarUsuarioException("Deve ser informado um comentário."); }
    }

    private void validaPreenchimentoDosCamposTransportador(Pessoa avaliador, Pessoa avaliado, Integer avaliacaoGeral, Boolean recomenda, String comentario, Integer tempoDeEntrega, Integer integridadeMercadoria) {
        validaPreenchimentoDosCamposAnunciante(avaliador, avaliado, avaliacaoGeral, recomenda, comentario);
        if (tempoDeEntrega == null) { throw new AvaliarUsuarioException("Deve ser informada uma nota para o tempo de entrega."); }
        if (integridadeMercadoria == null) { throw new AvaliarUsuarioException("Deve ser informada uma nota para a integridade da mercadoria."); }
    }

    private void validaAvaliacaoGeral(Integer avaliacaoGeral) {
        if (avaliacaoGeral < 0 || avaliacaoGeral > 5) {
            throw new AvaliarUsuarioException("Avaliação geral deve ser um número entre 0 e 5.");
        }
    }

    private void validaTempoDeEntrega(Integer tempoDeEntrega) {
        if (tempoDeEntrega != null && (tempoDeEntrega < 0 || tempoDeEntrega > 100)) {
            throw new AvaliarUsuarioException("Tempo de entrega deve ser um número entre 0 e 100.");
        }
    }

    private void validaIntegridadeMercadoria(Integer integridadeMercadoria) {
        if (integridadeMercadoria != null && (integridadeMercadoria < 0 || integridadeMercadoria > 100)) {
            throw new AvaliarUsuarioException("Integridade da mercadoria deve ser um número entre 0 e 100.");
        }
    }

    public Pessoa getAvaliador() {
        return avaliador;
    }

    public Pessoa getAvaliado() {
        return avaliado;
    }

    public Integer getAvaliacaoGeral() {
        return avaliacaoGeral;
    }

    public Boolean getRecomenda() {
        return recomenda;
    }

    public Integer getTempoDeEntrega() {
        return tempoDeEntrega;
    }

    public Integer getIntegridadeMercadoria() {
        return integridadeMercadoria;
    }

    public String getComentario() {
        return comentario;
    }

    public AvaliadoComo getAvaliadoAvaliadoComo() {
        return avaliadoAvaliadoComo;
    }
}