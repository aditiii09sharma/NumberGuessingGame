//METHOD2
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    
    private static final int MAX_ATTEMPTS = 5; // Maximum attempts per round
    private static final int RANGE = 100; // Range of numbers (1 to 100)
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        boolean playAgain;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        do {
            int score = playRound(scanner);
            totalScore += score;
            
            System.out.println("Your score for this round: " + score);
            System.out.println("Total score: " + totalScore);
            
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        
        System.out.println("Thank you for playing! Your final score is: " + totalScore);
        scanner.close();
    }
    
    // Function to play a single round
    private static int playRound(Scanner scanner) {
        Random random = new Random();
        int targetNumber = random.nextInt(RANGE) + 1;
        int attempts = 0;
        
        System.out.println("\nNew Round: Guess a number between 1 and " + RANGE + "!");
        
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number correctly.");
                return calculateScore(attempts);
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
            
            System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
        }
        
        System.out.println("Out of attempts! The correct number was: " + targetNumber);
        return 0;
    }
    
    // Function to calculate score based on number of attempts
    private static int calculateScore(int attempts) {
        int score;
        switch (attempts) {
            case 1: score = 10; break;
            case 2: score = 8; break;
            case 3: score = 6; break;
            case 4: score = 4; break;
            case 5: score = 2; break;
            default: score = 0; break;
        }
        return score;
    }
}
