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

## Criterios de aceptación

- Dado: el usuario escribe una receta sin nombre, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado: el usuario escribe una receta con menos de 1 ingrediente, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta con más de 30 ingredientes, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta sin indicar el tipoPlato, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta sin añadir foto, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta con menos de 1 paso o más de 30 pasos, Cuando se trate de construir el objeto Receta Entonces lanza RecetaInvalidaException.
- Dado el usuario escribe una receta con nombre, al menos 1 ingrediente, con tipoPlato, foto añadida, al menos 1 paso, Cuando se trate de construir el objeto Receta Entonces se construye correctamente y el sistema asigna fecha, vecesRepetida=1 y fechaUltimaRepeticion.