package Entities;
import Utilities.Dice;

public class Creature extends Player {

    private final Creatures creatureClass;


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

    // ------------------------------------------End of Getters and Setters-----------------------------------------

    public boolean isDead() {
        return this.getHp() <= 0;
    }


    public static Creature creatureSpawner(int faces){
        int experienceDice = Dice.DiceFunction(faces);
        Levels lvlDice = Levels.getRndLvl(Dice.DiceFunction(10));
        int hpDice = Dice.DiceFunction(faces);
        int mpDice = Dice.DiceFunction(faces);
        int strengthDice = Dice.DiceFunction(faces);
        int randomCreature = Dice.DiceFunction(6);
        return new Creature(Creatures.getRandomCreature(randomCreature), experienceDice, lvlDice,
                hpDice, mpDice, strengthDice);
    }
}
