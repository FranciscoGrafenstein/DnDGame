package Entities;

public enum PlayerClasses {
    WARRIOR("Warrior", 12, 10, 2, 5, 10),
    MAGE("Mage", 20, 8, 1, 15, 20),
    THIEF("Thief", 10, 8, 1, 5, 8),
    PALADIN("Paladin", 18, 12, 3, 8, 15),
    RANGER("Ranger", 10, 10, 1, 6, 9);

    private final String type;
    private final int hp;
    private final int mp;
    private final int strength;
    private final int defense;
    private final int magicalMight;



    PlayerClasses(String type, int hp, int strength, int defense, int magicalMight, int mp) {
        this.type = type;
        this.hp = hp;
        this.strength = strength;
        this.defense = defense;
        this.magicalMight = magicalMight;
        this.mp = mp;
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

    public int getDefense() {
        return defense;
    }

    public int getMagicalMight() {
        return magicalMight;
    }

    public int getMP() {
        return mp;
    }
}
