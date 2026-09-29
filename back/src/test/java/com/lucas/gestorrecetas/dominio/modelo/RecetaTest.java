package com.lucas.gestorrecetas.dominio.modelo;
import com.lucas.gestorrecetas.dominio.excepciones.RecetaInvalidaException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
public class RecetaTest {

    @Test
    void lanzaExcepcionSiFaltaNombre(){
        assertThrows(RecetaInvalidaException.class,
                ()->Receta.builder().build());
    }

    @Test
    void lanzaExcepcionSiNoHayIngredientes(){
        assertThrows(RecetaInvalidaException.class,
                ()->Receta.builder()
                        .nombre("Tortilla")
                        .ingredientes(List.of())
                        .build());
    }

    @Test
    void lanzaExcepcionSiHayMas30Ingrdientes(){
        assertThrows(RecetaInvalidaException.class,
                ()->Receta.builder()
                        .nombre("Tortilla")
                        .ingredientes(Collections.nCopies(31,new RecetaIngrediente("sal",1d,"al gusto")))
                        .build());
    }

    @Test
    void lanzaExcepcionSiNoHayTipoPlato(){
        assertThrows(RecetaInvalidaException.class,
                ()->Receta.builder()
                        .nombre("Tortilla")
                        .ingredientes(List.of(new RecetaIngrediente("huevo",1d,"unidad")))
                        .tipoPlato(null)
                        .build());
    }
}
