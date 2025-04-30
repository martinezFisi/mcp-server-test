# YuGiOh Card API MCP Server

Este proyecto implementa un servidor MCP (Model Context Protocol) que actúa como wrapper para la API de YuGiOh Card Database (YGOPRODeck).

## Descripción

El servidor proporciona una interfaz MCP para buscar cartas de YuGiOh utilizando diversos criterios de filtrado. Utiliza la API pública de YGOPRODeck para obtener la información de las cartas.

## Requisitos Previos

- Java 21 o superior
- Maven 3.6 o superior

## Instalación

1. Clonar el repositorio
```bash
git clone [url-del-repositorio]
```

2. Construir el proyecto
```bash
mvn clean package
```

## Uso

El servidor MCP expone una herramienta llamada "yugioh-api" que acepta varios parámetros para filtrar cartas. Algunos ejemplos de uso:

### Parámetros Disponibles

- **name**: Nombre exacto de la carta (ej: "Dark Magician")
- **id**: ID de la carta (ej: "46986414")
- **type**: Tipo de carta (ej: "Effect Monster", "Spell Card", etc.)
- **atk**: Puntos de ataque
- **def**: Puntos de defensa
- **level**: Nivel/Rango de la carta
- **race**: Tipo de monstruo (ej: "Spellcaster", "Dragon", etc.)
- **attribute**: Atributo (ej: "DARK", "LIGHT", etc.)
- **archetype**: Arquetipo (ej: "Blue-Eyes")
- **sort**: Campo para ordenar resultados (ej: "atk", "name")
- **format**: Formato del juego (ej: "tcg", "speed duel")
- **banlist**: Lista de prohibidas (ej: "TCG", "OCG")
- **language**: Idioma (ej: "en", "fr")

### Ejemplos de Uso

Para buscar una carta específica:
```json
{
    "name": "Dark Magician"
}
```

Para buscar cartas de un arquetipo específico:
```json
{
    "archetype": "Blue-Eyes"
}
```

Para buscar cartas con criterios múltiples:
```json
{
    "type": "Effect Monster",
    "attribute": "DARK",
    "race": "Spellcaster"
}
```

## Estructura del Proyecto

- `App.java`: Clase principal que implementa el servidor MCP
- `YugiohSchema.java`: Define el schema JSON para la validación de parámetros
