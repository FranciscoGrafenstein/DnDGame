package Interactions;

import Entities.Player;
import Entities.PlayerChoice;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Choices {

    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                number = sc.nextInt();
                if (number <= 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid option! ");
                sc.nextLine();
            }
        }
        return number;
    }

    public static int getUserInput(String var) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                number = sc.nextInt();
                if (number <= 0) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter valid option! ");
                System.out.print(var + ": ");
                sc.nextLine();
            }
        }
        return number;
    }

    public static PlayerChoice choice() {
        PlayerChoice choice;
        System.out.println("What is your action?: " +
                "\t 1 Attack" +
                "\t 2 Defend" +
                "\t 3 Escape" +
                "\t 4 Item Bag" +
                "\t 5 Equipment" +
                "\t 6 Check Stats");
        int playerChoice;
        playerChoice = getUserInput("What is your action?: " +
                "\t 1 Attack" +
                "\t 2 Defend" +
                "\t 3 Escape" +
                "\t 4 Item Bag" +
                "\t 5 Equipment" +
                "\t 6 Check Stats");
        if (Objects.equals(playerChoice, 1)) {
            choice = PlayerChoice.ATTACK;
        } else if (Objects.equals(playerChoice, 2)) {
            choice = PlayerChoice.DEFEND;
        } else if (Objects.equals(playerChoice, 3)) {
            choice = PlayerChoice.ESCAPE;
        } else if (Objects.equals(playerChoice, 4)) {
            choice = PlayerChoice.ITEMS;
        } else if (Objects.equals(playerChoice, 5)) {
            choice = PlayerChoice.EQUIPMENT;
        } else if (Objects.equals(playerChoice, 6)) {
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
        System.out.print("What is your action?: " +
                "\t 1 Use item" +
                "\t 2 Drop item" +
                "\t 3 Go back");
        int playerChoice;
        playerChoice = getUserInput();
        if (Objects.equals(playerChoice, 1)) {
            bagChoice = PlayerChoice.USE_ITEM;
        } else if (Objects.equals(playerChoice, 2)) {
            bagChoice = PlayerChoice.DROP;
        } else if (Objects.equals(playerChoice, 3)) {
            bagChoice = PlayerChoice.GO_BACK;
        } else {
            bagChoice = PlayerChoice.INVALID;
        }
        return bagChoice;
    }


}
