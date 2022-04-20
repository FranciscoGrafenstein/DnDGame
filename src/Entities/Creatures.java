package Entities;

public enum Creatures {
    OGRE("Ogre", 15, 18),
    ZOMBIE("Zombie", 20, 9),
    GOBLIN("Goblin", 10, 10),
    TROLL("Troll", 40, 30),
    DRAUGR("Draugr", 25, 12),
    VAMPIRE("Vampire", 50, 30),
    DRAGON("Dragon", 60, 45),
    WEREWOLF("Werewolf", 30, 25),
    ;

    private final String type;
    private final int hp;
    private final int strength;


    Creatures(String type, int hp, int strength) {
        this.type = type;
        this.hp = hp;
        this.strength = strength;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }


    public static Creatures getRandomCreature(int index) {
        Creatures randomCreature = null;

        if (index == 1) {
            randomCreature = OGRE;
        }
        if (index == 2) {
            randomCreature = ZOMBIE;
        }
        if (index == 3) {
            randomCreature = GOBLIN;
        }
        if (index == 4) {
            randomCreature = TROLL;
        }
        if (index == 5) {
            randomCreature = DRAUGR;
        }
        if (index == 6) {
            randomCreature = WEREWOLF;
        }
        if (index == 7) {
            randomCreature = VAMPIRE;
        }
        if (index == 8) {
            randomCreature = DRAGON;
        }
        return randomCreature;
    }
}
