package com.time06.escoladeti.anuncio.command;

import com.time06.escoladeti.anuncio.exception.InstanciarAnuncioException;
import com.time06.escoladeti.endereco.CriarEnderecoCommand;
import com.time06.escoladeti.infraestrutura.Util;

import java.util.Date;
import java.util.List;

public abstract class CriarAnuncioCommand {

    private String titulo;
    private Date dataValidade;
    private String idPessoa;
    private CriarEnderecoCommand enderecoOrigem;
    private CriarEnderecoCommand enderecoDestino;
    private String contatoOrigem;
    private String telefoneOrigem;
    private String contatoDestino;
    private String telefoneDestino;
    private String observacao;
    private List<String> fotos;

    public CriarAnuncioCommand(
            String titulo,
            String idPessoa,
            CriarEnderecoCommand enderecoOrigem,
            CriarEnderecoCommand enderecoDestino,
            Date dataValidade,
            String contatoOrigem,
            String telefoneOrigem,
            String contatoDestino,
            String telefoneDestino,
            String observacao,
            List<String> fotos) {
        if (Util.vazio(titulo)) throw new InstanciarAnuncioException("Anúncio deve ter um título!");
        if (Util.vazio(idPessoa)) throw new InstanciarAnuncioException("Anúncio deve ter uma pessoa!");
        if (enderecoOrigem == null) throw new InstanciarAnuncioException("Anúncio deve ter um Endereço de Origem!");
        if (enderecoDestino == null) throw new InstanciarAnuncioException("Anúncio deve ter um Endereço de Destino!");
        if (dataValidade == null) throw new InstanciarAnuncioException("Anúncio deve ter uma data de validade!");

        this.titulo = titulo;
        this.idPessoa = idPessoa;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.dataValidade = dataValidade;
        this.contatoOrigem = contatoOrigem;
        this.telefoneOrigem = telefoneOrigem;
        this.contatoDestino = contatoDestino;
        this.telefoneDestino = telefoneDestino;
        this.observacao = observacao;
        this.fotos = fotos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdPessoa() {
        return idPessoa;
    }

    public CriarEnderecoCommand getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public CriarEnderecoCommand getEnderecoDestino() {
        return enderecoDestino;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public String getContatoOrigem() {
        return contatoOrigem;
    }

    public String getTelefoneOrigem() {
        return telefoneOrigem;
    }

    public String getContatoDestino() {
        return contatoDestino;
    }

    public String getTelefoneDestino() {
        return telefoneDestino;
    }

    public String getObservacao() {
        return observacao;
    }

    public List<String> getFotos() {
        return fotos;
    }

}