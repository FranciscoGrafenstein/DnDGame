package Magic;

public enum Spells {
    FIRE_BALL("Fire Ball", 5, 30),
    ICE_BALL("Ice Ball", 5, 30),
    ;

    private static Spells spellNames;
    private final String spellName;
    private final int damage;
    private final int manaCost;


    Spells(String spellName, int damage, int manaCost) {
        this.spellName = spellName;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    @Override
    public String toString() {
        return spellName;
    }

    public static Spells getSpellName() {
        return spellNames;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

}
