package Entities;

import Utilities.Dice;

import java.util.Random;

public class Creature extends Player {

    private final Creatures creatureClass;
    private CreatureLevels level;


    public Creature(Creatures creatureClass, int experience, Levels level, int hp, int mp, int strength) {
        super(experience, level, hp, mp, strength);
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
        int randomExp = randExp.nextInt(20-8) + 8;
        int experienceDice = (Dice.DiceFunction(faces) + randomExp);
        // Rest of values
        Levels lvlDice = Levels.getRndLvl(randomLevel);
        int hpDice = Dice.DiceFunction(faces);
        int mpDice = Dice.DiceFunction(faces);
        int strengthDice = Dice.DiceFunction(faces);
        int randomCreature = Dice.DiceFunction(6);
        return new Creature(Creatures.getRandomCreature(randomCreature), experienceDice, lvlDice,
                hpDice, mpDice, strengthDice);
    }

    public static Creature creatureLeveler(Creature enemy){
        enemy.setHp(enemy.getHp() + enemy.getLevel().getHp());
        enemy.setMp(enemy.getMp() + enemy.getLevel().getMp());
        enemy.setStrength(enemy.getStrength() + enemy.getLevel().getStrength());
        enemy.setMagicalMight(enemy.getMagicalMight() + enemy.getLevel().getMagicalMight());
        return enemy;
    }

}
