package Items;

import Entities.Player;

public class Items {

    public static void addItemBag(Player character, ItemList item, int amount) {
        if (character.getItemBag().containsKey(item)) {
            int amountItem = character.getItemBag().get(item) + amount;
            character.getItemBag().put(item, amountItem);
        } else {
            character.getItemBag().put(item, amount);
        }
    }

    public static void useItemBag(Player character, ItemList item, int amount) {
        if (character.getItemBag().containsKey(item)) {
            int amountItem = character.getItemBag().get(item) - amount;
            character.getItemBag().put(item, amountItem);
            if (character.getItemBag().get(item) == 0) {
                character.getItemBag().remove(item);
            }
        } else {
            System.out.println("You don't have that item");
        }
    }
}
