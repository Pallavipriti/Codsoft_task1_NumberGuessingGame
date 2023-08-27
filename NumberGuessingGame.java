import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 200;
        int maxAttempts = 10;
        
        int score = 0;
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("You have chosen a number between " + minRange + " and " + maxRange + ". Try to guess it.");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = in.nextInt();
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } 
                else if ((userGuess - targetNumber)>5) {
                    System.out.println("Your guess is too high. Try again.");
                }
                 else if ((targetNumber-userGuess)>5){
                    System.out.println("Your guess is too low. Try again.");
                }
                else if(userGuess>targetNumber){
                    System.out.println("Your guess is little bit higher to target num.try again");
                }
                else {
                    System.out.println("Your guess is little bit lower to target num.try again");
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber + ".");
                }
            }
            
            System.out.print("Do you want to play again? (y/n): ");
            String playAgainInput = in.next();
            playAgain = playAgainInput.equalsIgnoreCase("y");
        }
        
        System.out.println("Game over! Your total score is : " + score);
    }
}
