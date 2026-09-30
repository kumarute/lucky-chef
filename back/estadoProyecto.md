# Estado del proyecto

## Cierre de sesión 2026-09-30

### Hecho
- Spec `01-Receta.md` ampliada: ingredientes inmutable, elemento nulo, lista original modificada, lista devuelta inmodificable.
- Tests en `RecetaTest`: `lanzaExcepcionSiUnIngredienteEsNull` y `laRecetaNoCambiaSiSeModificaLaListaOriginal` (verde).
- `Receta`: `List.copyOf` en el constructor, `getIngredientes()`.

### Pendiente (siguiente sesión)
1. Test `laListaDevueltaEsInmodificable` (`assertThrows(UnsupportedOperationException.class, ...)` con un `add` sobre `getIngredientes()`).
2. Refactor: copiar primero y validar la copia (cerrar ventana TOCTOU), con tests en verde.
3. Campos de la spec aún sin modelar: foto, pasos, tiempoPreparacion, comentarioPersonal, valoraciones, fecha, vecesRepetida, fechaUltimaRepeticion.
4. Limpiar indentación y typos en `Receta.java` (mensaje "no puedo contener").

### Notas
- Gradle no corre desde WSL (falta JDK 25); ejecutar tests desde IDE/Windows.
- Cambios sin commit: `CLAUDE.md`, `RecetaTest`, `Receta`, spec y los .md nuevos.
- Repaso de inicio de la próxima sesión: pedir que explique por qué el `anyMatch(Objects::isNull)` va antes de `List.copyOf`.
