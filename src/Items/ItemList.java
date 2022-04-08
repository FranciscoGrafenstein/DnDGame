package Items;

public enum ItemList {
    HP_POTY("Health Potion", 15),
    MP_POTY("Mana Potion", 15),
    ;

    private final String itemName;
    private final int restore;

    ItemList(String itemName, int restore) {
        this.itemName = itemName;
        this.restore = restore;
    }

    @Override
    public String toString() {
        return  itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getRestore() {
        return restore;
    }
}
