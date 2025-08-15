import java.util.Random; 
import java.util.Scanner; 

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        // And our scanner, so we can listen to your guesses.
        Scanner scanner = new Scanner(System.in);

        //Now we'll set the range for our secret number. Let's make it between 1 and 100.
        int lowerBound = 1;
        int upperBound = 100;
        // The computer picks a number! Adding 1 because nextInt(n) gives numbers from 0 to n-1.
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Let's keep track of how many tries you take.
        int attempts = 0;
        // This will be your guess. We'll start it at 0 for now.
        int userGuess;
        // A little flag to know when you've finally got it right!
        boolean hasGuessedCorrectly = false;

        System.out.println("Hello there! I've picked a secret number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Can you guess what it is?");

        // This loop will keep running until you guess the correct number.
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: "); // Prompting you for your guess!

           // Let's ensure you type a number.
            while (!scanner.hasNextInt()) {
                System.out.println("Oops! That's not a number. Please enter a whole number.");
                scanner.next(); 
                System.out.print("Enter your guess: "); // Ask again!
            }
            userGuess = scanner.nextInt(); // Grab your valid number guess.
            attempts++; // Every time you guess, we count it!

            // Now, let's give you some hints! Is your guess too high, too low, or just right?
            if (userGuess < lowerBound || userGuess > upperBound) {
                System.out.println("Hey, stay in the lines! Your guess is outside the range (" + lowerBound + "-" + upperBound + "). Try again!");
            } else if (userGuess < secretNumber) {
                System.out.println("Too low! My secret number is higher. 😉");
            } else if (userGuess > secretNumber) {
                System.out.println("Too high! My secret number is lower. ⬇️");
            } else {
               
                System.out.println("Congratulations! You guessed my secret number: " + secretNumber + "!");
                System.out.println("It took you " + attempts + " attempt(s) to get it right. 🎉");
                hasGuessedCorrectly = true; // Set the flag to true to end the loop.
            }
        }

        scanner.close(); // Good practice: close the scanner when the game is over.
        System.out.println("Thanks for playing!");
    }
}