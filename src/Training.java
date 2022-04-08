import Entities.*;
import Interactions.Combat;
import Items.*;
import Magic.Magic;
import Magic.Spells;

import java.io.IOException;

public class Training {

    public static void main(String[] args) throws IOException {

        Player character = new Player("Pancho", PlayerClasses.MAGE);
        Creature firstCreature = new Creature(Creatures.DRAUGR, 30, Levels.LEVEL_2, 25, 35, 15);
        Creature secondCreature = new Creature(Creatures.VAMPIRE, 40, Levels.LEVEL_3, 25, 10, 15);
        Creature thirdCreature = new Creature(Creatures.ZOMBIE, 30, Levels.LEVEL_2, 25, 10, 15);
        character.characterCreationSystem();
        Magic.addSpell(character, Spells.FIRE_BALL);
        Magic.addSpell(character, Spells.ICE_BALL);

        Items.addItemBag(character, ItemList.HP_POTY, 2);
        Items.addItemBag(character, ItemList.MP_POTY, 1);

        while (!character.isDead()){
            Combat.Encounter(Creature.creatureSpawner(20), character, Spells.getSpellName());
        }

        if (character.isDead()){
            Visuals.youDied();
        }

    }
}