package com.lucas.gestorrecetas.dominio.modelo;

import com.lucas.gestorrecetas.dominio.excepciones.IngredienteInvalidoException;

public record RecetaIngrediente(String nombre, Double cantidad, String unidad) {
    public RecetaIngrediente {
        if (nombre == null || nombre.isBlank()) {
            throw new IngredienteInvalidoException("El ingrediente debe tener nombre");
        }
    }
}
