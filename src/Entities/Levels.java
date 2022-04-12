package Entities;

public enum Levels {
    LEVEL_1("1", 10),
    LEVEL_2("2", 22),
    LEVEL_3("3", 33),
    LEVEL_4("4", 44),
    LEVEL_5("5", 55),
    LEVEL_6("6", 66),
    LEVEL_7("7", 77),
    LEVEL_8("8", 88),
    LEVEL_9("9", 99),
    LEVEL_10("10", 110),
    ;
    private final String lvlName;
    private final int expNeeded;

    Levels(String lvlName, int expNeeded) {
        this.lvlName = lvlName;
        this.expNeeded = expNeeded;
    }

    public String getLvlName() {
        return lvlName;
    }

    public int getExpNeeded() {
        return expNeeded;
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
