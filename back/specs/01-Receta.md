# Spec: Receta

## Descripción:
Receta es la representación de mis recetas de cocina con su información completa como ingredientes,
tiempos, pasos y categorias además incluimos la valoración personal.

## Reglas:
- nombre: obligatorio y no vacío
- ingredientes: obligatorio, minimo 1 máximo 30 como limite practico ingredientes vía RecetaIngrediente (cantidad/unidad es opcional)
- tipoPlato: obligatorio, enum cerrado {ensaladas, guisos, pastas, carnes, pescados}
- foto: imagen obligatoria
- pasos: obligatorio, mínimo 1 máximo 30 como limite de práctico , es una lista simple orden = índice 
- tiempoPreparacion es opcional
- comentarioPersonal es opcional
- valoraciones: opcional lista de VO Valoracion{autor, nota, fecha, comentario}
- fecha (creación), vecesRepetida (empieza en 1), fechaUltimaRepeticion: gestionados por el sistema, no por el usuario.
- Invariante de fondo: todo esto se valida en el dominio (no se puede construir una Receta inválida), no es una regla de persistencia
- ingredientes debe ser una lista inmutable

## Criterios de aceptación

- Dado: el usuario escribe una receta sin nombre, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado: el usuario escribe una receta con menos de 1 ingrediente, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta con más de 30 ingredientes, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta sin indicar el tipoPlato, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta sin añadir foto, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta con menos de 1 paso o más de 30 pasos, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta con nombre, al menos 1 ingrediente, con tipoPlato, foto añadida, al menos 1 paso, Cuando se trate de construir el objeto Receta Entonces se construye correctamente y el sistema asigna fecha, vecesRepetida=1 y fechaUltimaRepeticion.
- Dado el usuario escribe una receta con una lista de ingredientes, Cuando se trata de modificar la lista devuelta por la receta en el código después de construir el objeto Entonces se lanza una UnsupportedOperationException.
- Dado el usuario escribe una receta con ingredientes y al menos uno de sus elementos es nulo, Cuando se trata de crear el objeto Entonces se lanza un RecetaInvalidaException.
- Dado una receta construida con una lista de ingredientes, Cuando se modifica la lista original despues de construir el objeto receta, Entonces la lista de la receta conserva los valores que tenía al construirse.