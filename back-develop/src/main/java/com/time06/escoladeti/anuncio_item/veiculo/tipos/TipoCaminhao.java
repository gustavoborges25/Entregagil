package com.time06.escoladeti.anuncio_item.veiculo.tipos;

public enum TipoCaminhao {

    URBANO_CARGA("Caminhão Urbano/Carga"),
    LS("Caminhão LS"),
    TOCO("Caminhão Toco"),
    DOIS_EIXOS("Caminhão com dois eixos"),
    TRUCK("Caminhão Truck"),
    TRES_EIXOS("Caminhão com três eixos"),
    EXTRA_PESADO("Camihão extra pesado"),
    BI_TREM("Camihão bitrem");

    private final String nome;

    TipoCaminhao(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
