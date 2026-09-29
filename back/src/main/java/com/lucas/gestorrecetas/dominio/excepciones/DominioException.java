package com.lucas.gestorrecetas.dominio.excepciones;

public abstract class DominioException extends RuntimeException {
    protected DominioException(String message) {
        super(message);
    }
}
