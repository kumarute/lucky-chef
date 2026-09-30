# Memoria del proyecto (histórico de decisiones)

## 2026-10-01 — Receta: lista devuelta inmodificable y plan TOCTOU
- Test `laListaDevueltaEsInmodificable` (`assertThrows(UnsupportedOperationException.class, ...)`). Nació en verde; se vio en rojo saboteando el getter (`new ArrayList<>(...)`).
- Decisión: getter devuelve lista inmodificable, no copia defensiva por llamada. Motivo: fail-fast y mínima sorpresa (un `add` sobre una copia falla en silencio).
- Plan refactor (pendiente): `new ArrayList<>(ingredientes)` → validar la copia → `List.copyOf(copia)`. Descartados: `try/catch` de NPE (smell) y `Collections.unmodifiableList` (frágil si la copia se filtra).
- Autoría: la vía ArrayList→validar→copyOf salió de pistas de Claude; la elección de `copyOf` frente a `unmodifiableList` y su argumento (robustez, inmutabilidad exigida por el dominio) fueron de Lucas.
- Perfil C.6 (primera medición): ante `pathspec did not match` en `git add`, el primer movimiento fue rodear el error con ruta absoluta, sin leer el prompt ni diagnosticar la causa (directorio actual incorrecto).
- Perfil C.3: escribió primero `add` + `assertEquals` (error, no fallo); tras pista, `assertThrows` correcto. Explicó bien por qué la lambda (evaluación eager de argumentos).

## 2026-09-30 — Receta: ingredientes inmutables y sin nulos
- Decisión: el constructor de `Receta` guarda `List.copyOf(ingredientes)` (copia defensiva, lista inmutable).
- Motivo: cerrar dos puertas al estado mutable: entrada (el llamador conserva la referencia) y salida (el getter).
- Decisión: elemento `null` dentro de la lista lanza `RecetaInvalidaException`, comprobado antes de `copyOf` con `stream().anyMatch(Objects::isNull)` (no `contains(null)`, que lanza NPE en listas inmutables).
- Decisión: `getIngredientes()` devuelve la lista interna, segura por ser inmutable.
- Spec actualizada: `specs/01-Receta.md` (regla "ingredientes inmutable" y 3 criterios nuevos).
- Aclaración: `Receta` usa constructor validante + `@Builder`, no un patrón factory.

## 2026-09-27 — Stack
- Java 25 LTS (ver historial en `CLAUDE.md`).
