import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsWon = 0;

        System.out.println(" NUMBER GUESSING GAME");


        boolean playAgain = true;

        while (playAgain) {

            // Generate a random number between 1 and 100
            int number = random.nextInt(100) + 1;

            int maxAttempts = 7;
            int attempts = 0;
            boolean won = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");
                    

            // Game loop
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int guess = 0;
                try {
                    guess = sc.nextInt();
                    
                    // Validate guess is within range
                    if (guess < 1 || guess > 100) {
                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    sc.nextLine(); // Clear the invalid input from buffer
                    continue;
                }

                attempts++;

                if (guess == number) {

                    System.out.println("Correct");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    won = true;
                    roundsWon++;

                    // Calculate score
                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("You earned " + score + " points!");

                    break;

                } else if (guess > number) {

                    System.out.println("Too high! Try a smaller number.");

                } else {

                    System.out.println("Too low! Try a bigger number.");
                }

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            // If player didn't guess correctly
            if (!won) {

                System.out.println("\n Game Over");
                System.out.println("The correct number was: " + number);
            }

            // Display current score
            System.out.println("\n-----------------------------");
            System.out.println("Current Score: " + totalScore);
            System.out.println("Rounds Won: " + roundsWon);
            System.out.println("-----------------------------");

            // Ask whether player wants another round
            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        // Final result
        System.out.println("\n=================================");
        System.out.println("          FINAL RESULT");
        System.out.println("=================================");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing! ");

        sc.close();
    }
}