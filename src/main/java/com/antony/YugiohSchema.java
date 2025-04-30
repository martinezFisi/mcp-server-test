package com.antony;

public class YugiohSchema {
    public static final String SCHEMA = """
            {
                "type": "object",
                "properties": {
                    "name": {
                        "type": "string",
                        "description": "Filter by exact card name (e.g. 'Dark Magician')"
                    },
                    "id": {
                        "type": "string",
                        "description": "Filter by card ID (e.g. '46986414')"
                    },
                    "type": {
                        "type": "string",
                        "description": "Filter by card type",
                        "enum": [
                            "Effect Monster", "Flip Effect Monster", "Gemini Monster", 
                            "Normal Monster", "Normal Tuner Monster", "Pendulum Effect Monster",
                            "Pendulum Flip Effect Monster", "Pendulum Normal Monster",
                            "Ritual Effect Monster", "Ritual Monster", "Spell Card",
                            "Spirit Monster", "Toon Monster", "Trap Card", "Tuner Monster",
                            "Union Effect Monster", "Fusion Monster", "Link Monster",
                            "Pendulum Effect Fusion Monster", "Synchro Monster",
                            "Synchro Pendulum Effect Monster", "Synchro Tuner Monster",
                            "XYZ Monster", "XYZ Pendulum Effect Monster"
                        ]
                    },
                    "atk": {
                        "type": "integer",
                        "description": "Filter by attack points (e.g. 2500)"
                    },
                    "def": {
                        "type": "integer",
                        "description": "Filter by defense points (e.g. 2100)"
                    },
                    "level": {
                        "type": "integer",
                        "description": "Filter by level/rank (e.g. 7)"
                    },
                    "race": {
                        "type": "string",
                        "description": "Filter by monster race/type",
                        "enum": [
                            "Aqua", "Beast", "Beast-Warrior", "Creator-God", "Cyberse",
                            "Dinosaur", "Divine-Beast", "Dragon", "Fairy", "Fiend",
                            "Fish", "Insect", "Machine", "Plant", "Psychic", "Pyro",
                            "Reptile", "Rock", "Sea Serpent", "Spellcaster", "Thunder",
                            "Warrior", "Winged Beast", "Wyrm", "Zombie"
                        ]
                    },
                    "attribute": {
                        "type": "string",
                        "description": "Filter by attribute",
                        "enum": ["DARK", "DIVINE", "EARTH", "FIRE", "LIGHT", "WATER", "WIND"]
                    },
                    "link": {
                        "type": "integer",
                        "description": "Filter by link rating (e.g. 4)",
                        "minimum": 1,
                        "maximum": 8
                    },
                    "linkmarker": {
                        "type": "string",
                        "description": "Filter by link markers (comma-separated)",
                        "pattern": "^(Top|Bottom|Left|Right|Bottom-Left|Bottom-Right|Top-Left|Top-Right)(,(Top|Bottom|Left|Right|Bottom-Left|Bottom-Right|Top-Left|Top-Right))*$"
                    },
                    "scale": {
                        "type": "integer",
                        "description": "Filter by Pendulum Scale (e.g. 8)",
                        "minimum": 0,
                        "maximum": 13
                    },
                    "cardset": {
                        "type": "string",
                        "description": "Filter by card set (e.g. 'Metal Raiders')"
                    },
                    "archetype": {
                        "type": "string",
                        "description": "Filter by archetype (e.g. 'Blue-Eyes')"
                    },
                    "banlist": {
                        "type": "string",
                        "description": "Filter by banlist",
                        "enum": ["TCG", "OCG", "GOAT"]
                    },
                    "sort": {
                        "type": "string",
                        "description": "Sort results by field",
                        "enum": ["atk", "def", "name", "type", "level", "id"]
                    },
                    "sortorder": {
                        "type": "string",
                        "description": "Sort order direction",
                        "enum": ["asc", "desc"]
                    },
                    "format": {
                        "type": "string",
                        "description": "Card format",
                        "enum": ["tcg", "ocg", "goat", "duel links", "rush duel", "speed duel"]
                    },
                    "staple": {
                        "type": "string",
                        "description": "Filter by staple cards (yes/no)",
                        "enum": ["yes", "no"]
                    },
                    "has_effect": {
                        "type": "string",
                        "description": "Filter cards with specific effects in their text"
                    },
                    "language": {
                        "type": "string",
                        "description": "Card language",
                        "enum": ["en", "fr", "de", "it", "pt"]
                    },
                    "num": {
                        "type": "integer",
                        "description": "Limit number of results",
                        "minimum": 1
                    },
                    "offset": {
                        "type": "integer",
                        "description": "Skip specific number of results",
                        "minimum": 0
                    }
                }
            }
            """;
}