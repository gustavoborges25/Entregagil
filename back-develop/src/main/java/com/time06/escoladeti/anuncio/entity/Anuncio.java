package com.time06.escoladeti.anuncio.entity;

import com.time06.escoladeti.anuncio.exception.InstanciarAnuncioException;
import com.time06.escoladeti.anuncio.type.TipoCategoria;
import com.time06.escoladeti.anuncio.type.TipoSubcategoria;
import com.time06.escoladeti.anuncio_item.AnuncioItem;
import com.time06.escoladeti.anuncio_item.veiculo.AnuncioItemCarro;
import com.time06.escoladeti.endereco.Endereco;
import com.time06.escoladeti.infraestrutura.ModeloBase;
import com.time06.escoladeti.pessoa.Pessoa;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Anuncio extends ModeloBase {

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "data_validade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Pessoa anunciante;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pessoa_transportador",
            referencedColumnName = "id",
            insertable = true,
            nullable = true)
    private Pessoa transportador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_origem",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Endereco enderecoOrigem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco_destino",
            referencedColumnName = "id",
            insertable = true,
            nullable = false)
    private Endereco enderecoDestino;

    @Column(name = "contato_origem")
    private String contatoOrigem;

    @Column(name = "telefone_origem")
    private String telefoneOrigem;

    @Column(name = "contato_destino")
    private String contatoDestino;

    @Column(name = "telefone_destino")
    private String telefoneDestino;

    @Column(name = "situacao", nullable = false)
    @Enumerated(EnumType.STRING)
    private AnuncioSituacao situacao;

    @Fetch(FetchMode.SELECT)
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ITEM", referencedColumnName = "ID")
    private AnuncioItem item;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria")
    private TipoCategoria categoria;

    @Enumerated(EnumType.STRING)
    @Column(name = "subcategoria")
    private TipoSubcategoria subcategoria;

    @ElementCollection
    @CollectionTable(name = "anuncio_foto", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "foto")
    private List<String> fotos;

    protected Anuncio() {
    }

    public Anuncio(String titulo, Date dataValidade, Pessoa anunciante, Endereco enderecoOrigem, Endereco enderecoDestino, String contatoOrigem, String telefoneOrigem, String contatoDestino, String telefoneDestino, AnuncioSituacao situacao, TipoCategoria categoria, TipoSubcategoria subcategoria, List<String> fotos) {
        if (titulo == null) throw new InstanciarAnuncioException("Anúncio deve ter um título!");
        if (anunciante == null) throw new InstanciarAnuncioException("Anúncio deve ter um anunciante!");
        if (enderecoOrigem == null) throw new InstanciarAnuncioException("Anúncio deve ter um Endereço de Origem!");
        if (enderecoDestino == null) throw new InstanciarAnuncioException("Anúncio deve ter um Endereço de Destino!");
        if (dataValidade == null) throw new InstanciarAnuncioException("Anúncio deve ter uma data de validade!");
        if (situacao == null) throw new InstanciarAnuncioException("Anúncio deve ter uma situação!");

        this.titulo = titulo;
        this.dataValidade = dataValidade;
        this.anunciante = anunciante;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.contatoOrigem = contatoOrigem;
        this.telefoneOrigem = telefoneOrigem;
        this.contatoDestino = contatoDestino;
        this.telefoneDestino = telefoneDestino;
        this.situacao = situacao;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.fotos = fotos;
    }

    public String getTitulo() {
        return titulo;
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

    public AnuncioSituacao getSituacao() {
        return situacao;
    }

    public AnuncioItem getItem() {
        return item;
    }

    public void setItem(AnuncioItem item) {
        this.item = item;
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

    public void cancelar() {
        this.situacao = AnuncioSituacao.CANCELADO;
    }

    public void cancelarTransporte() {
        this.situacao = AnuncioSituacao.RECEBENDO_LANCE;
        this.transportador = null;
    }

    public void definirTransportador(Pessoa transportador) {
        this.transportador = transportador;
    }

}