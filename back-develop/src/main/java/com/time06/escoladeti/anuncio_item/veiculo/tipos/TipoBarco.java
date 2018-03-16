package com.time06.escoladeti.anuncio_item.veiculo.tipos;

public enum TipoBarco {

    A_MOTOR("Barco à motor"),
    A_VELA("Barco à vela"),
    MOTO_AQUATICA("Moto aquática"),
    OUTROS("Outros");

    private final String nome;

    TipoBarco(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
