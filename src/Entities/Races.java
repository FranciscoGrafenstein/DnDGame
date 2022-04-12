package Entities;

public enum Races {
    HUMAN("Human", 5, 3, 2, 1, 1),
    ELF("Elf", 5, 9, 8, 2, 5),
    DWARF("Dwarf", 9, 2, 6, 4, 2),
    HALF_ELF("Half Elf", 5, 7, 6, 3, 5),
    HALF_ORC("Half Orc", 7, 3, 4, 4, 2),
    DRAGONBORN("Dragonborn", 8, 7, 7, 5, 5);

    private final String name;
    private final int hp;
    private final int mp;
    private final int strength;
    private final int defense;
    private final int magicalMight;


    Races(String name, int hp, int mp, int strength, int defense, int magicalMight) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.strength = strength;
        this.defense = defense;
        this.magicalMight = magicalMight;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
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

}
