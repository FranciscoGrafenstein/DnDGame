package Magic;

import Entities.Player;

public class Magic {

    // Checks if character already has the spell, and if it doesn't, it adds it
    public static void addSpell(Player character, Spells spell) {
        if (character.getSpells().contains(spell.toString())) {
            System.out.println("You know have that spell");
        } else {
            character.getSpells().add(spell.toString());
        }
    }

    // Checks if character has enough mana to cast the spell, and removes the mana cost form the mana pool
    public static void useSpell(Player character, Spells spell, int manaCost) {
        if (!character.getSpells().contains(spell.toString())) {
            System.out.println("You don't have that spell yet");
        } else {
            character.setMp(character.getMp() - manaCost);
        }

    }

}
