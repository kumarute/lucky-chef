package com.lucas.gestorrecetas.dominio.modelo;
import com.lucas.gestorrecetas.dominio.excepciones.RecetaInvalidaException;
import com.lucas.gestorrecetas.dominio.modelo.enums.TipoPlato;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class RecetaTest {

    static class ListaTramposa extends ArrayList<RecetaIngrediente> {

        @Override
        public Object[] toArray(){
            RecetaIngrediente valido = new RecetaIngrediente("huevos",1d,"unidades");
            Object[] resultado = new Object[31];
            Arrays.fill(resultado,valido);
            return resultado;
        }
    }

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

    @Test
    void lanzaExcepcionSiUnIngredienteEsNull() {
         var conNull = Arrays.asList(new RecetaIngrediente("huevo", 1d, "unidad"), null);
         assertThrows(RecetaInvalidaException.class,
                 ()->Receta.builder()
                         .nombre("tortilla")
                         .ingredientes(conNull)
                         .tipoPlato(TipoPlato.CARNES)
                         .build());
    }

    @Test
    void laRecetaNoCambiaSiSeModificaLaListaOriginal(){
       var listaIngredientes = new ArrayList<RecetaIngrediente>();
        listaIngredientes.add(new RecetaIngrediente("huevos",1d,"unidad"));
        listaIngredientes.add(new RecetaIngrediente("patata",3d,"unidades"));
        Receta receta = new Receta("Sopa",listaIngredientes,TipoPlato.CARNES);
        listaIngredientes.clear();
        assertEquals(2, receta.getIngredientes().size());
    }

    @Test
    void laListaDevueltaEsInmodificable(){
        List<RecetaIngrediente> listaIngredientes = List.of(new RecetaIngrediente("huevos",1d,"unidades"));
        Receta receta = new Receta("Sopa",listaIngredientes,TipoPlato.ENSALADAS);
        assertThrows(UnsupportedOperationException.class,
                ()->receta.getIngredientes().add(new RecetaIngrediente("jamon",1d,"gr")));
    }

    @Test
    void lanzaExcepcionSiLaListaCambiaEntreValidacionYCopia(){
        ListaTramposa tramposa  = new ListaTramposa();
        tramposa.add(new RecetaIngrediente("huevo",1d,"unidad"));
        RecetaInvalidaException exception = assertThrows(RecetaInvalidaException.class,
                ()-> new Receta("sopa",tramposa,TipoPlato.ENSALADAS));
        assertEquals("La receta no puede contener más de 30 ingredientes",exception.getMessage());
    }
}
