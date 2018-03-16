package com.time06.escoladeti.anuncio.entity;

import com.time06.escoladeti.anuncio.type.TipoCategoria;
import com.time06.escoladeti.anuncio.type.TipoSubcategoria;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.pessoa.Pessoa;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Retorno para a tela. Itens são retornados como chave-valor.
 */
public class AnuncioRetornoDTO {

    private String titulo;
    private Date dataValidade;
    private Pessoa anunciante;
    private Pessoa transportador;
    private Endereco enderecoOrigem;
    private Endereco enderecoDestino;
    private String contatoOrigem;
    private String telefoneOrigem;
    private String contatoDestino;
    private String telefoneDestino;
    private AnuncioSituacao situacao;
    private List<Map<String, Object>> item;
    private TipoCategoria categoria;
    private TipoSubcategoria subcategoria;
    private List<String> fotos;

    public AnuncioRetornoDTO(Anuncio anuncio, List<Map<String, Object>> item) {
        this.titulo = anuncio.getTitulo();
        this.dataValidade = anuncio.getDataValidade();
        this.anunciante = anuncio.getAnunciante();
        this.transportador = anuncio.getTransportador();
        this.enderecoOrigem = anuncio.getEnderecoOrigem();
        this.enderecoDestino = anuncio.getEnderecoDestino();
        this.contatoOrigem = anuncio.getContatoOrigem();
        this.telefoneOrigem = anuncio.getTelefoneOrigem();
        this.contatoDestino = anuncio.getContatoDestino();
        this.telefoneDestino = anuncio.getTelefoneDestino();
        this.situacao = anuncio.getSituacao();
        this.item = item;
        this.categoria = anuncio.getCategoria();
        this.subcategoria = anuncio.getSubcategoria();
        this.fotos = anuncio.getFotos();
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public Pessoa getAnunciante() {
        return anunciante;
    }

    public Pessoa getTransportador() {
        return transportador;
    }

    public Endereco getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public Endereco getEnderecoDestino() {
        return enderecoDestino;
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

    public AnuncioSituacao getSituacao() {
        return situacao;
    }

    public List<Map<String, Object>> getItem() {
        return item;
    }

    public TipoCategoria getCategoria() {
        return categoria;
    }

    public TipoSubcategoria getSubcategoria() {
        return subcategoria;
    }

    public List<String> getFotos() {
        return fotos;
    }

}
