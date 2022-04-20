package Entities;

public enum CreatureLevels {
    LEVEL_1("1", 5, 5, 5, 6, 1, 4),
    LEVEL_2("2", 9, 10, 10, 8, 1, 4),
    LEVEL_3("3", 13, 16, 14, 10, 1, 4),
    LEVEL_4("4", 16, 18, 16, 12, 1, 5),
    LEVEL_5("5", 20, 25, 18, 13, 1, 5),
    LEVEL_6("6", 23, 32, 20, 14, 2, 5),
    LEVEL_7("7", 26, 45, 22, 15, 2, 5),
    LEVEL_8("8", 30, 50, 24, 16, 2, 6),
    LEVEL_9("9", 34, 55, 26, 17, 2, 6),
    LEVEL_10("10", 38, 70, 28, 18, 3, 7),
    ;
    private final String lvlName;
    private final int experience;
    private final int hp;
    private final int mp;
    private final int strength;
    private final int defense;
    private final int magicalMight;

    CreatureLevels(String lvlName, int experience, int hp, int mp, int strength, int defense, int magicalMight) {
        this.lvlName = lvlName;
        this.experience = experience;
        this.hp = hp;
        this.mp = mp;
        this.strength = strength;
        this.defense = defense;
        this.magicalMight = magicalMight;
    }

    public String getLvlName() {
        return lvlName;
    }

    public int getExperience() {
        return experience;
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

    public static CreatureLevels getNextLvl(CreatureLevels currentLvl) {
        int current = Integer.parseInt(currentLvl.getLvlName());
        int nxt = current + 1;

        CreatureLevels nxtLvl = null;

        if (nxt == 2) {
            nxtLvl = LEVEL_2;
        }
        if (nxt == 3) {
            nxtLvl = LEVEL_3;
        }
        if (nxt == 4) {
            nxtLvl = LEVEL_4;
        }
        if (nxt == 5) {
            nxtLvl = LEVEL_5;
        }
        if (nxt == 6) {
            nxtLvl = LEVEL_6;
        }
        if (nxt == 7) {
            nxtLvl = LEVEL_7;
        }
        if (nxt == 8) {
            nxtLvl = LEVEL_8;
        }
        if (nxt == 9) {
            nxtLvl = LEVEL_9;
        }
        if (nxt == 10) {
            nxtLvl = LEVEL_10;
        }

        return nxtLvl;
    }

    public static CreatureLevels getRndCreatureLvl(int randomLvl) {
        CreatureLevels nxtLvl = null;

        if (randomLvl == 1) {
            nxtLvl = LEVEL_1;
        }
        if (randomLvl == 2) {
            nxtLvl = LEVEL_2;
        }
        if (randomLvl == 3) {
            nxtLvl = LEVEL_3;
        }
        if (randomLvl == 4) {
            nxtLvl = LEVEL_4;
        }
        if (randomLvl == 5) {
            nxtLvl = LEVEL_5;
        }
        if (randomLvl == 6) {
            nxtLvl = LEVEL_6;
        }
        if (randomLvl == 7) {
            nxtLvl = LEVEL_7;
        }
        if (randomLvl == 8) {
            nxtLvl = LEVEL_8;
        }
        if (randomLvl == 9) {
            nxtLvl = LEVEL_9;
        }
        if (randomLvl == 10) {
            nxtLvl = LEVEL_10;
        }

        return nxtLvl;
    }
}
