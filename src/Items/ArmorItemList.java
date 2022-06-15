package Items;

public enum ArmorItemList {
    LEATHER_HELMET("Leather Helmet", 2, ArmorType.HELMET),
    LEATHER_CHEST("Leather Chestplate", 4, ArmorType.CHEST),
    LEATHER_LEGS("Leather Pants", 3, ArmorType.LEGS),
    LEATHER_BOOTS("Leather Boots", 1, ArmorType.FEET),
    LEATHER_GLOVES("Leather Gloves", 1, ArmorType.HANDS),
    STEEL_HELMET("Steel Helmet", 4, ArmorType.HELMET),
    STEEL_CHEST("Steel Chestplate", 6, ArmorType.CHEST),
    STEEL_LEGS("Steel Legs", 5, ArmorType.LEGS),
    STEEL_BOOTS("Steel Boots", 3, ArmorType.FEET),
    STEEL_GLOVES("Steel Gloves", 3, ArmorType.HANDS),
    ;

    private final String itemName;
    private final int armor;
    private final ArmorType type;

    ArmorItemList(String itemName, int armor, ArmorType type) {
        this.itemName = itemName;
        this.armor = armor;
        this.type = type;
    }

    public String getItemName() {
        return itemName;
    }

    public int getArmor() {
        return armor;
    }

    public ArmorType getType(){
        return type;
    }

    @Override
    public String toString() {
        return itemName;
    }

}
