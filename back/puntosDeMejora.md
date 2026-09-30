# Puntos de mejora

## Referencia vs copia (aliasing)
- `this.x = x` con una colección guarda la referencia del llamador, no una copia.
- Un objeto que protege invariantes no debe compartir estado mutable con el exterior: copia defensiva (`List.copyOf`).
- Copiar primero y validar la copia: lo validado debe ser lo guardado (TOCTOU).

## Factory vs Builder
- `@Builder` de Lombok no es un patrón factory: solo facilita pasar argumentos. La garantía viene de que el constructor valida antes de asignar.

## Spec antes que tests
- Orden del proyecto: spec → tests → implementación → infraestructura.
- Los tests se derivan de la spec. Se escribieron tests de reglas que la spec no recogía; se corrigió la spec primero.
- La spec describe el **qué** (comportamiento), no el **cómo** (implementación). Ej.: "conserva los ingredientes que tenía al construirse", no "conserva la copia".

## Redactar criterios de aceptación
- El "Entonces" describe el estado o resultado, no lo primero que se te ocurre (no todo lanza excepción).
- Un criterio = un comportamiento. Separar "lista devuelta" y "lista original".
- Precisión de términos: inmutable ≠ invariante.

## Tests
- Un test rojo solo vale si falla por la razón correcta (lista vacía en el arrange, expectativa 1 vs 2).
- Comprobar que lo que afirma el `assert` es lo que se espera, no el bug.

## APIs de Java
- `List.of(...).contains(null)` lanza NPE; las listas inmutables rechazan `null` incluso en consultas.
- `List.copyOf` lanza NPE con `null` o elementos `null`: comprobar antes con tu propia excepción.
- `var` es nativo desde Java 10; no importar `lombok.var`.

## Estilo
- Indentación consistente (usar *Reformat code* del IDE).
