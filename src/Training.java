import Entities.*;
import Interactions.Combat;
import Items.*;
import Magic.Magic;
import Magic.Spells;

import java.io.IOException;

public class Training {

    public static void main(String[] args) throws IOException {
        Player character = new Player("Pancho", PlayerClasses.MAGE, Races.HALF_ELF);
        Magic.addSpell(character, Spells.FIRE_BALL);
        Magic.addSpell(character, Spells.ICE_BALL);
        Items.addItemBag(character, ConsumableItemList.HP_POTY, 2);
        Items.addItemBag(character, ConsumableItemList.MP_POTY, 1);
        ArmorItems.addArmor(character, ArmorItemList.STEEL_HELMET, ArmorType.HELMET);
        ArmorItems.addArmor(character, ArmorItemList.STEEL_CHEST, ArmorType.CHEST);
        ArmorItems.addArmor(character, ArmorItemList.STEEL_BOOTS, ArmorType.FEET);



        character.playerStats();
        while (!character.isDead()) {
            Creature enemy = Creature.creatureSpawner(20, character);
            Creature.creatureLeveler(enemy);
            Combat.Encounter(enemy, character);
        }
        if (character.isDead()) {
            Visuals.youDied();
        }

    //    Hola mi amor te amo <3
    }
}