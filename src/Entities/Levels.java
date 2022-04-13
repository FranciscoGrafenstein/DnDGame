package Entities;

public enum Levels {
    LEVEL_1("1", 10, 10, 10, 5, 1, 4),
    LEVEL_2("2", 50, 12, 10, 6, 1, 4),
    LEVEL_3("3", 90, 16, 14, 7, 1, 4),
    LEVEL_4("4", 150, 18, 16, 8, 1, 5),
    LEVEL_5("5", 220, 20, 18, 9, 1, 5),
    LEVEL_6("6", 290, 24, 20, 10, 2, 5),
    LEVEL_7("7", 360, 26, 22, 11, 2, 5),
    LEVEL_8("8", 410, 28, 24, 12, 2, 6),
    LEVEL_9("9", 520, 30, 26, 13, 2, 6),
    LEVEL_10("10", 680, 35, 28, 14, 3, 7),
    ;
    private final String lvlName;
    private final int expNeeded;
    private final int hp;
    private final int mp;
    private final int strength;
    private final int defense;
    private final int magicalMight;

    Levels(String lvlName, int expNeeded, int hp, int mp, int strength, int defense, int magicalMight) {
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

    public static Levels getNextLvl(Levels currentLvl) {
        int current = Integer.parseInt(currentLvl.getLvlName());
        int nxt = current + 1;

        Levels nxtLvl = null;

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

    public static Levels getRndLvl(int randomLvl) {
        Levels nxtLvl = null;

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
