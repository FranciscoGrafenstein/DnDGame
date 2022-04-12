package Interactions;

import Entities.Player;
import Entities.PlayerChoice;

import java.util.Objects;
import java.util.Scanner;

public class Choices {

    public static PlayerChoice choice() {
        PlayerChoice choice;
        System.out.println("What is your action?: " +
                "\t 1 Attack" +
                "\t 2 Defend" +
                "\t 3 Escape" +
                "\t 4 Item Bag" +
                "\t 5 Check Stats");
        Scanner in = new Scanner(System.in);
        String playerChoice = in.nextLine();
        if (Objects.equals(Integer.parseInt(playerChoice), 1)) {
            choice = PlayerChoice.ATTACK;
        } else if (Objects.equals(Integer.parseInt(playerChoice), 2)) {
            choice = PlayerChoice.DEFEND;
        } else if (Objects.equals(Integer.parseInt(playerChoice), 3)) {
            choice = PlayerChoice.ESCAPE;
        } else if (Objects.equals(Integer.parseInt(playerChoice), 4)) {
            choice = PlayerChoice.ITEMS;
        } else if (Objects.equals(Integer.parseInt(playerChoice), 5)) {
            choice = PlayerChoice.STATS;
        } else {
            choice = PlayerChoice.INVALID;
        }
        return choice;
    }

    public static PlayerChoice BagChoice(Player character) {
        PlayerChoice bagChoice = null;
        System.out.println("Item bag: ");
        System.out.println(character.getItemBag());
        System.out.println("What is your action?: " +
                "\t 1 Use item" +
                "\t 2 Go back");
        Scanner in = new Scanner(System.in);
        String playerChoice = in.nextLine();
        if (Objects.equals(Integer.parseInt(playerChoice), 1)) {
            bagChoice = PlayerChoice.USE_ITEM;
        }
        if (Objects.equals(Integer.parseInt(playerChoice), 2)) {
            bagChoice = PlayerChoice.GO_BACK;
        }
        return bagChoice;
    }


}
