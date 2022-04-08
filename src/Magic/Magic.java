package Magic;

import Entities.Player;

public class Magic {

    public static void addSpell(Player character, Spells spell) {
        if (character.getSpells().contains(spell.toString())) {
            System.out.println("You know have that spell");
        } else {
            character.getSpells().add(spell.toString());
        }
    }

    public void useSpell(Player character, Spells spell, int manaCost) {
        if (!character.getSpells().contains(spell.toString())) {
            System.out.println("You don't have that spell yet");
        } else {
            character.setMp(character.getMp() - manaCost);
        }

    }

}
