package com.time06.escoladeti.anuncio_item.veiculo.tipos;

public enum TipoTransporteGuinchoCegonha {

    GUINCHO("Guincho (sem utilização de motorista)"),
    CEGONHA("Cegonha (com utilização de motorista)"),
    SEM_PREFERENCIA("Não tenho preferência");

    private final String nome;

    TipoTransporteGuinchoCegonha(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

}
