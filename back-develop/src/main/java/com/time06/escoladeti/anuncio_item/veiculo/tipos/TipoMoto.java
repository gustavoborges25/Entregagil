package com.time06.escoladeti.anuncio_item.veiculo.tipos;

public enum TipoMoto {

    MOTO("Moto"),
    TRICICULO("Tricículo"),
    QUADRICICULO("Quadricículo"),
    MOTONETA("Motoneta");

    private final String nome;

    TipoMoto(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
