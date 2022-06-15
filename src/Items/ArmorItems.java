package Items;

import Entities.Player;

public class ArmorItems extends Items {

    public static void addArmor(Player character, ArmorItemList item, ArmorType type) {
        if (character.getArmorType(type.getType()).isEmpty()) {
            character.getArmorType(type.getType()).add(item);
            character.setDefense(character.getDefense() + item.getArmor());
        } else {
            System.out.println("You already have something on");
        }
    }

    public static void removeArmor(Player character, ArmorItemList item, ArmorType type) {
        if (!character.getArmorType(type.getType()).isEmpty()) {
            character.getArmorType(type.getType()).remove(item);
            character.setDefense(character.getDefense() - item.getArmor());
        } else {
            System.out.println("You have nothing to remove");
        }
    }

    public static void showEquipment(Player character){
        if (character.getHelmetArmor().isEmpty()){
            System.out.println("[No helmet equipped]");
        }
        else {
            System.out.println(character.getHelmetArmor());
        }
        if (character.getChestArmor().isEmpty()){
            System.out.println("[No chestplate equipped]");
        }
        else {
            System.out.println(character.getChestArmor());
        }
        if (character.getLegsArmor().isEmpty()){
            System.out.println("[No pants equipped]");
        }
        else {
            System.out.println(character.getLegsArmor());
        }
        if (character.getHandsArmor().isEmpty()){
            System.out.println("[No gloves equipped]");
        }
        else {
            System.out.println(character.getHandsArmor());
        }
        if (character.getFeetArmor().isEmpty()){
            System.out.println("[No boots equipped]");
        }
        else {
            System.out.println(character.getFeetArmor());
        }
    }
}
