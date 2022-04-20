package Entities;

import Items.ItemList;
import Items.Items;
import Utilities.Dice;

import java.util.Random;

public class Creature extends Player {

    private final Creatures creatureClass;
    private CreatureLevels level;


    public Creature(Creatures creatureClass, int experience, CreatureLevels level, int hp, int mp,
                    int strength, int gold, int escapeChance) {
        super(experience, hp, mp, strength, gold, escapeChance);
        this.level = level;
        this.creatureClass = creatureClass;
        this.setHp(hp + this.getCreatureClass().getHp());
        this.setStrength(strength + this.getCreatureClass().getStrength());
    }

    // ---------------------------------------------Getters and Setters-----------------------------------------

    public Creatures getCreatureClass() {
        return creatureClass;
    }

    public Creatures setCreatureClass() {
        return creatureClass;
    }

    public CreatureLevels getCreatureLevel() {
        return level;
    }

    public void setCreatureLevel(CreatureLevels level) {
        this.level = level;
    }
// ------------------------------------------End of Getters and Setters-----------------------------------------

    public boolean isDead() {
        return this.getHp() <= 0;
    }

    public int setIsDead(){
        return this.setHp(0);
    }

    // Creates a new creature with random stats
    public static Creature creatureSpawner(int faces, Player character) {
        // Level Randomizer
        int playerLevel = Integer.parseInt(character.getLevel().getLvlName());
        Random randLevel = new Random();
        int randomLevel = randLevel.nextInt((playerLevel + 2) -(playerLevel - 2)) + (playerLevel - 2);
        if (randomLevel <= 0){
            randomLevel = 1;
        }

        // Experience Randomizer
        Random randExp = new Random();
        int randomExp = randExp.nextInt(10-5) + 5;
        int experienceDice = (Dice.DiceFunction(faces) + randomExp);

        // Rest of values
        CreatureLevels lvlDice = CreatureLevels.getRndCreatureLvl(randomLevel);
        int hpDice = Dice.DiceFunction(faces);
        int mpDice = Dice.DiceFunction(faces);
        int strengthDice = Dice.DiceFunction(faces);
        int goldDice = (Dice.DiceFunction(faces) + 10);
        int escapeDice = Dice.DiceFunction(faces);
        int randomCreature = Dice.DiceFunction(8);
        return new Creature(Creatures.getRandomCreature(randomCreature), experienceDice, lvlDice,
                hpDice, mpDice, strengthDice, goldDice, escapeDice);
    }

    // Takes the created creature with random stats, and based on the random level, it raises the stats
    public static void creatureLeveler(Creature enemy){
        enemy.setHp(enemy.getHp() + enemy.getCreatureLevel().getHp());
        enemy.setMp(enemy.getMp() + enemy.getCreatureLevel().getMp());
        enemy.setStrength(enemy.getStrength() + enemy.getCreatureLevel().getStrength());
        enemy.setMagicalMight(enemy.getMagicalMight() + enemy.getCreatureLevel().getMagicalMight());
        enemy.setExperience(enemy.getExperience() + enemy.getCreatureLevel().getExperience());
    }

    // item dropper
    public void creatureDrop(Creature enemy, Player character, ItemList item){
        int dropChance = Dice.DiceFunction(100);
        if (dropChance > 70){
            Items.addItemBag(character, item, 1);
            System.out.println(enemy.getCreatureClass().getType() + " dropped: " + item.getItemName());
        }
    }
    public  void superDrop(Creature enemy, Player character, ItemList item){
        int dropChance = Dice.DiceFunction(100);
        if (dropChance > 95){
            Items.addItemBag(character, item, 1);
            System.out.println(enemy.getCreatureClass().getType() + " dropped: " + item.getItemName());
        }
    }

    public void drop(Creature enemy, Player character){
        enemy.creatureDrop(enemy, character, ItemList.MP_POTY);
        enemy.creatureDrop(enemy, character, ItemList.HP_POTY);
        enemy.superDrop(enemy, character, ItemList.MP_SUPER_POTY);
        enemy.superDrop(enemy, character, ItemList.HP_SUPER_POTY);
    }
}