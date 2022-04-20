package Utilities;

import java.util.Random;
import java.util.Scanner;

public class Dice {


    private final Random rand;
    private final int faces;

    public Dice(int faces) {
        this.rand = new Random();
        this.faces = faces;
    }

    public int roll() {
        return 1 + rand.nextInt(faces);
    }

    // Method that waits for input to roll a die
    public static void DiceRoller() {
        Scanner input = new Scanner(System.in);
        System.out.println("Utilities.Dice Roller\n");
        System.out.println("How many faces does the dice have?");
        Dice dice = new Dice(input.nextInt());
        System.out.println("\nThe dice rolled a " + dice.roll() + ".");
    }

    // Method that rolls a die without input
    public static int DiceFunction(int faces) {
        Dice dice = new Dice(faces);
        return dice.roll();
    }


}

