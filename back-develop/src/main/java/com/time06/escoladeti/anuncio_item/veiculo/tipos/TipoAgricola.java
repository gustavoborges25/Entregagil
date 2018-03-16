package com.time06.escoladeti.anuncio_item.veiculo.tipos;

public enum TipoAgricola {

    AGRICOLA("Agrícola"),
    CONSTRUCAO("Construção");

    private final String nome;

    TipoAgricola(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
