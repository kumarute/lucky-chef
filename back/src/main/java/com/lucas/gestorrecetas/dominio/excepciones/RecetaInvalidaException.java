package com.lucas.gestorrecetas.dominio.excepciones;

public class RecetaInvalidaException extends DominioException  {
    public RecetaInvalidaException(String message) {
        super(message);
    }
}
