package Entities;

public enum PlayerChoice {
    ATTACK("Attack"),
    DEFEND("Defend"),
    ESCAPE("Escape"),
    ITEMS("Items"),
    STATS("Stats"),
    USE_ITEM("Use item"),
    GO_BACK("Go back"),
    PICK_UP("Pick up item"),
    DROP("Drop item"),

    ;

    PlayerChoice(String choice) {
    }

}