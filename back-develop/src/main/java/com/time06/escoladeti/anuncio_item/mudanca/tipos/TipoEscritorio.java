package com.time06.escoladeti.anuncio_item.mudanca.tipos;

public enum TipoEscritorio {

    TERREO("Térreo"),
    PREDIO("Prédio");

    private final String nome;

    TipoEscritorio(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
