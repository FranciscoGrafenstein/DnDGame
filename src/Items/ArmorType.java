package Items;

import java.util.List;

import static Entities.Player.helmetArmor;
import static Entities.Player.chestArmor;
import static Entities.Player.legsArmor;
import static Entities.Player.feetArmor;
import static Entities.Player.handsArmor;

public enum ArmorType {
    HELMET("Helmet", helmetArmor),
    CHEST("Chestplate", chestArmor),
    LEGS("Legs", legsArmor),
    FEET("Feet", feetArmor),
    HANDS("Gloves", handsArmor),
    ;


    private final String name;
    private final List type;

    ArmorType(String name, List type) {
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public List getType(){
        return type;
    }



}
