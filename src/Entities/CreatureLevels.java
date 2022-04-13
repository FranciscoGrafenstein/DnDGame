package Entities;

public enum CreatureLevels {
    LEVEL_1("1", 10, 5, 5, 2, 1, 4),
    LEVEL_2("2", 22, 6, 10, 4, 1, 4),
    LEVEL_3("3", 33, 7, 14, 5, 1, 4),
    LEVEL_4("4", 44, 8, 16, 6, 1, 5),
    LEVEL_5("5", 55, 9, 18, 7, 1, 5),
    LEVEL_6("6", 66, 10, 20, 8, 2, 5),
    LEVEL_7("7", 77, 12, 22, 9, 2, 5),
    LEVEL_8("8", 88, 14, 24, 10, 2, 6),
    LEVEL_9("9", 99, 16, 26, 12, 2, 6),
    LEVEL_10("10", 110, 18, 28, 14, 3, 7),
    ;
    private final String lvlName;
    private final int expNeeded;
    private final int hp;
    private final int mp;
    private final int strength;
    private final int defense;
    private final int magicalMight;

    CreatureLevels(String lvlName, int expNeeded, int hp, int mp, int strength, int defense, int magicalMight) {
        this.lvlName = lvlName;
        this.expNeeded = expNeeded;
        this.hp = hp;
        this.mp = mp;
        this.strength = strength;
        this.defense = defense;
        this.magicalMight = magicalMight;
    }

    public String getLvlName() {
        return lvlName;
    }

    public int getExpNeeded() {
        return expNeeded;
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

    public static CreatureLevels getRndLvl(int randomLvl) {
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
