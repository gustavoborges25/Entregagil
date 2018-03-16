package com.time06.escoladeti.anuncio.type;

public enum TipoSubcategoria {

    CARRO_CAMINHONETE, MOTO, BARCO, CAMINHAO, AGRICULA_CONSTRUCAO, ESPORTE, PECA,
    ELETRONICO, ELETRODOMESTICO, ELETROPORTATEIS, MOVEL, TELEFONIA, COMPUTADOR, ACESSORIO, ANIMAL,
    CASA, SOBRADO, APARTAMENTO, KITNET, ESCRITORIO, INDUSTRIA, COMERCIO,
    CARGA_FRACIONADA, CARGA_COMPLETA, CARGA_AGRICOLA, CARGA_PERECIVEL, CARGA_VIVA, CARGA_FRAGIL, CARGA_PERIGOSA, CONTAINER,
    OUTROS;

    public static TipoSubcategoria porString(String s) {
        switch (s) {
            case "carro":
                return CARRO_CAMINHONETE;
            case "moto":
                return MOTO;
            case "barco":
                return BARCO;
            case "caminhao":
                return CAMINHAO;
            case "agricola":
                return AGRICULA_CONSTRUCAO;
            case "esporte":
                return ESPORTE;
            case "peca":
                return PECA;
            case "eletronico":
                return ELETRONICO;
            case "eletrodomestico":
                return ELETRODOMESTICO;
            case "eletroportateis":
                return ELETROPORTATEIS;
            case "movel":
                return MOVEL;
            case "telefonia":
                return TELEFONIA;
            case "computador":
                return COMPUTADOR;
            case "acessorio":
                return ACESSORIO;
            case "animal":
                return ANIMAL;
            case "casa":
                return CASA;
            case "sobrado":
                return SOBRADO;
            case "apartamento":
                return APARTAMENTO;
            case "kitnet":
                return KITNET;
            case "escritorio":
                return ESCRITORIO;
            case "industria":
                return INDUSTRIA;
            case "comercio":
                return COMERCIO;
            case "carga_fracionada":
                return CARGA_FRACIONADA;
            case "carga_completa":
                return CARGA_COMPLETA;
            case "carga_agricola":
                return CARGA_AGRICOLA;
            case "carga_perecivel":
                return CARGA_PERECIVEL;
            case "carga_viva":
                return CARGA_VIVA;
            case "carga_fragil":
                return CARGA_FRAGIL;
            case "carga_perigosa":
                return CARGA_PERIGOSA;
            case "container":
                return CONTAINER;
            default:
                throw new RuntimeException("Categoria não encontrada.");
        }
    }

}
