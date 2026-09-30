# Memoria del proyecto (histórico de decisiones)

## 2026-09-30 — Receta: ingredientes inmutables y sin nulos
- Decisión: el constructor de `Receta` guarda `List.copyOf(ingredientes)` (copia defensiva, lista inmutable).
- Motivo: cerrar dos puertas al estado mutable: entrada (el llamador conserva la referencia) y salida (el getter).
- Decisión: elemento `null` dentro de la lista lanza `RecetaInvalidaException`, comprobado antes de `copyOf` con `stream().anyMatch(Objects::isNull)` (no `contains(null)`, que lanza NPE en listas inmutables).
- Decisión: `getIngredientes()` devuelve la lista interna, segura por ser inmutable.
- Spec actualizada: `specs/01-Receta.md` (regla "ingredientes inmutable" y 3 criterios nuevos).
- Aclaración: `Receta` usa constructor validante + `@Builder`, no un patrón factory.

## 2026-09-27 — Stack
- Java 25 LTS (ver historial en `CLAUDE.md`).
