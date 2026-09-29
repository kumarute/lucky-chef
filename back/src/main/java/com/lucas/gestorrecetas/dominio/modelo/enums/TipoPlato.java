package com.lucas.gestorrecetas.dominio.modelo.enums;

public enum TipoPlato {
    ENSALADAS("ensaladas"),
    GUISOS("guisos"),
    PASTAS("pastas"),
    CARNES("carnes"),
    PESCADOS("pescados");

    private final String tipo;

    private TipoPlato(String tipo){
        this.tipo = tipo;
    }

    public String getTipoPlato(){return tipo;}
}
