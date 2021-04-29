/*
* This program generates a random number and
* lets the user guess it
*
* @author  Sean McLeod
* @version 1.0
* @since   2021-04-27
*/

import java.util.Scanner;
import java.util.Random;


final class DiceGame {
    private DiceGame() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    public static void main(final String[] args) {
        final int high = 6;
        final int low = 1;
        int numberOfTries = 1;
        int guessNumber;
        Scanner guessString = new Scanner(System.in);

        // generate randon number
        Random rand = new Random();
        int randomNumber = rand.nextInt(high - low + 1) + low;


        while (true) {
            // input
            System.out.print("Guess a number between 1 to 6: ");
            try {
                guessNumber = guessString.nextInt();

                if (guessNumber >= low && guessNumber <= high) {
                    if (guessNumber == randomNumber) {
                        // output
                        System.out.println("\nYou are correct!");
                        System.out.println("It took you " + numberOfTries
                                           + " tries");
                        break;
                    } else {
                        System.out.println("Guess again");
                    }
                } else {
                    System.out.println("This isn't between 1 to 6."
                                       + "This wont count\n");
                    /* when the user enters in a value that is not an
                    option, it doesn't count as an attempt */
                    numberOfTries -= 1;
                }


            } catch (Exception ex) {
                System.err.print("This is not an integer");
                break;
            }
            // keep track of the number of tries
            numberOfTries++;
        }
    }
}
