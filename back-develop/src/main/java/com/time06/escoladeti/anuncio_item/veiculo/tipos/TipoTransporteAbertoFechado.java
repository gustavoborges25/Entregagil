package com.time06.escoladeti.anuncio_item.veiculo.tipos;

public enum TipoTransporteAbertoFechado {

    CAMINHAO_CARROCERIA_ABERTA("Somente caminhão com carroceria aberta"),
    CAMINHAO_CARROCERIA_FECHADA("Somente caminhão com carroceria fechada"),
    SEM_PREFERENCIA("Não tenho preferência");

    private final String nome;

    TipoTransporteAbertoFechado(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
