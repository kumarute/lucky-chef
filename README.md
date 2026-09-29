# lucky-chef

Gestor de recetas personal con un agente de recomendación basado en IA.

Es un proyecto de aprendizaje: el objetivo no es entregar rápido, sino escribir el código a mano
y razonar cada decisión de diseño. La IA está configurada como mentor —plantea dilemas y hace
preguntas— y no como generador de código. Las reglas están en [`back/CLAUDE.md`](back/CLAUDE.md).

## Objetivos de aprendizaje

- Soltura escribiendo código sin asistencia
- Fundamentos y patrones de diseño
- Spring Boot en profundidad
- SDD + TDD: spec breve → tests de dominio → implementación mínima → infraestructura
- Integración de IA desacoplada del proveedor

## Arquitectura

Hexagonal (Ports & Adapters). El dominio no depende de Spring, de JPA ni del SDK de IA.
Para los proveedores de IA se usa el patrón Strategy, separando el puerto de caso de uso
(`RecomendadorDePlatos`) del puerto técnico (`ClienteModeloIA`).

## Stack

**Backend:** Java 25 (LTS) · Spring Boot 4.1.1 · Jakarta EE · Lombok · Gradle
**Frontend:** Angular 22 · TypeScript *(pendiente)*
**Datos:** PostgreSQL · Liquibase · Docker Compose
**IA:** Spring AI, abstraído tras un puerto propio

## Estado

En construcción. Dominio de `Receta` con validación de invariantes en el constructor.

| Módulo | Estado |
|---|---|
| Dominio: `Receta`, `RecetaIngrediente`, `TipoPlato` | Parcial — faltan `foto`, `pasos` y campos de sistema |
| Persistencia | Pendiente |
| API REST | Pendiente |
| Agente de recomendación | Pendiente |
| Frontend | Pendiente |

Las especificaciones funcionales viven en [`back/specs/`](back/specs).

## Arranque

```bash
cd back
docker compose up -d     # PostgreSQL
./gradlew test           # tests de dominio
./gradlew bootRun
```
