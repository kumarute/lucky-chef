package com.lucas.gestorrecetas.dominio.modelo;

import com.lucas.gestorrecetas.dominio.excepciones.RecetaInvalidaException;
import com.lucas.gestorrecetas.dominio.modelo.enums.TipoPlato;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Receta {

    private final String nombre;

    private final List<RecetaIngrediente> ingredientes;

    private final TipoPlato tipoPlato;

    @Builder
    public Receta(String nombre,List<RecetaIngrediente>ingredientes, TipoPlato tipoPlato) {
    if(nombre == null || nombre.isBlank()){
        throw new RecetaInvalidaException("El nombre de receta es obligatorio");
        }
    if (ingredientes == null){
        throw new RecetaInvalidaException("La receta debe tener al menos un ingrediente");
    }

    List<RecetaIngrediente> copia = new ArrayList<>(ingredientes);

    if (copia.isEmpty()){
        throw new RecetaInvalidaException("La receta debe tener al menos un ingrediente");
    }

    if (copia.size()>30){
        throw new RecetaInvalidaException("La receta no puede contener más de 30 ingredientes");
    }
    if (copia.stream().anyMatch(Objects::isNull)){
        throw new RecetaInvalidaException("La receta no puede contener ingredientes nulos");
    }

    if (tipoPlato == null){
        throw new RecetaInvalidaException("La receta debe tener tipo de plato seleccionado");
    }
    this.nombre = nombre;
    this.ingredientes = List.copyOf(copia);
    this.tipoPlato = tipoPlato;
    }

    public List<RecetaIngrediente> getIngredientes(){
        return ingredientes;
    }
}
