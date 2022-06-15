package Items;

public enum ConsumableItemList {
    HP_POTY("Health Potion", 15),
    MP_POTY("Mana Potion", 15),
    HP_SUPER_POTY("Super Health Potion", 50),
    MP_SUPER_POTY("Super Mana Potion", 50)
    ;

    private final String itemName;
    private final int restore;

    ConsumableItemList(String itemName, int restore) {
        this.itemName = itemName;
        this.restore = restore;
    }

    @Override
    public String toString() {
        return itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getRestore() {
        return restore;
    }

}
