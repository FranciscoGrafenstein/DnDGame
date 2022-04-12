import Entities.*;
import Interactions.Combat;
import Items.*;
import Magic.Magic;
import Magic.Spells;

import java.io.IOException;

public class Training {

    public static void main(String[] args) throws IOException {

        Player character = new Player("Pancho", PlayerClasses.MAGE, Races.HALF_ELF);
        character.characterCreationSystem();
        Magic.addSpell(character, Spells.FIRE_BALL);
        Magic.addSpell(character, Spells.ICE_BALL);
        Items.addItemBag(character, ItemList.HP_POTY, 2);
        Items.addItemBag(character, ItemList.MP_POTY, 1);

        while (!character.isDead()) {
            Combat.Encounter(Creature.creatureSpawner(20), character);
        }
        if (character.isDead()) {
            Visuals.youDied();
        }

    }
}