package com.time06.escoladeti.anuncio.type;

public enum TipoCategoria {

    CARGA, DOMESTICO, MUDANCA, OUTROS, VEICULO;

    public static TipoCategoria porString(String s) {
        switch (s) {
            case "veiculo":
                return VEICULO;
            case "domestico":
                return DOMESTICO;
            case "carga":
                return CARGA;
            case "mudanca":
                return MUDANCA;
            case "outros":
                return OUTROS;
            default:
                throw new RuntimeException("Categoria não encontrada.");
        }
    }

}
