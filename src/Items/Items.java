package Items;

import Entities.Player;

public class Items {

    // Checks if the character already has an instance of that item, and adds a new one
    public static void addItemBag(Player character, ConsumableItemList item, int amount) {
        if (character.getItemBag().containsKey(item)) {
            int amountItem = character.getItemBag().get(item) + amount;
            character.getItemBag().put(item, amountItem);
        } else {
            character.getItemBag().put(item, amount);
        }
    }

    // Checks if the character already has an instance of that item, and removes one
    public static void useItemBag(Player character, ConsumableItemList item, int amount) {
        if (character.getItemBag().containsKey(item)) {
            int amountItem = character.getItemBag().get(item) - amount;
            character.getItemBag().put(item, amountItem);
            if (character.getItemBag().get(item) == 0) {
                character.getItemBag().remove(item);
            }
        }
    }


    public static void useConsumable(Player character, ConsumableItemList item){
        if (character.getItemBag().containsKey(item)) {
            Items.useItemBag(character, item, 1);
            if (item == ConsumableItemList.HP_POTY){
                character.setHp(character.getHp() + item.getRestore());
                System.out.println("Current health: " + character.getHp());
            }else if (item == ConsumableItemList.MP_POTY){
                character.setMp(character.getMp() + item.getRestore());
                System.out.println("Current mana: " + character.getMp());
            }else if (item == ConsumableItemList.HP_SUPER_POTY){
                character.setHp(character.getHp() + item.getRestore());
                System.out.println("Current health: " + character.getHp());
            }else if (item == ConsumableItemList.MP_SUPER_POTY){
                character.setMp(character.getMp() + item.getRestore());
                System.out.println("Current mana: " + character.getMp());
            }
        }else{
            System.out.println("You don't have that item");
        }
    }
}
