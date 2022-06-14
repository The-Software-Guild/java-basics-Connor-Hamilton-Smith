
import java.util.Random;
import java.util.Scanner;

/**
 *  A class to play rock, paper, scissors
 *  Accepts user input in multiple forms:
 *      - Rock, Paper, Scissors,
 *      - rock paper scissors
 *      - r, p, s
 *      - 1, 2, 3
 *  Plays the user input against a randomly selected option
 *  Declares the winner after N rounds
 */
public class RockPaperScissors
{
    public static void main (String[] args)
    {
        Random rGen =   new Random();
        Scanner userInput = new Scanner(System.in);

        // Game loop
        for (;;)
        {
            // Variables to keep track of the outcome of each round
            int numberOfRounds = 0;
            int numberOfWins = 0, numberOfLosses = 0, numberOfTies = 0;
            // Get the desired number of rounds from user input
            System.out.println("\nHow many rounds would you like to play? : ");
            numberOfRounds = userInput.nextInt();
            // Skip to the next line for the next user input
            userInput.nextLine();

            // Ensure that the selected number of rounds is within the limit
            if (numberOfRounds <= 0 || numberOfRounds > 10)
            {
                System.out.println("Only values between 1 and 10 will be accepted. Exiting...");
                return;
            }

            // Loop through N rounds
            for (int i = 1; i <= numberOfRounds; i++)
            {
                System.out.println("\nRound " + i);

                // For each round, determine the user's move
                System.out.println("Do you choose rock, paper or scissors? : ");
                String answer = userInput.nextLine();

                // Use a switch with cascading cases to standardise any variations in input value
                switch (answer)
                {
                    case "Rock":
                    case "rock":
                    case "r":
                    case "1":
                        System.out.println("You have selected rock.");
                        answer = "1";
                        break;
                    case "Paper":
                    case "paper":
                    case "p":
                    case "2":
                        System.out.println("You have selected paper.");
                        answer = "2";
                        break;
                    case "Scissors":
                    case "scissors":
                    case "s":
                    case "3":
                        System.out.println("You have selected scissors.");
                        answer = "3";
                        break;
                    default:
                        System.out.print("That is not one of the options. Exiting...");
                        return;
                }

                // Choose a random integer between 0(incl) and 3(excl), then shift up by 1
                int opponent = rGen.nextInt(3) + 1;

                // Determine the outcome of the round
                if (answer == "1")
                {
                    // Rock against rock ties
                    if (opponent == 1)
                        numberOfTies += Tie("rock");
                    // Rock against paper loses etc...
                    else if (opponent == 2)
                        numberOfLosses += Lose("paper");
                    else if (opponent == 3)
                        numberOfWins += Win("scissors");
                }
                else if (answer == "2")
                {
                    if (opponent == 1)
                        numberOfWins += Win("rock");
                    else if (opponent == 2)
                        numberOfTies += Tie("paper");
                    else if (opponent == 3)
                        numberOfLosses += Lose("scissors");
                }
                else
                {
                    if (opponent == 1)
                        numberOfLosses += Lose("rock");
                    else if (opponent == 2)
                        numberOfWins += Win("paper");
                    else if (opponent == 3)
                        numberOfTies += Tie("scissors");
                }
            }

            // Declare the winner based on number of wins vs number of losses
            System.out.println("You won " + numberOfWins + " rounds out of " + numberOfRounds);
            if (numberOfWins > numberOfLosses)
                System.out.println("You win the game!");
            else if (numberOfWins < numberOfLosses)
                System.out.println("You lose the game :(");
            else
                System.out.println("The game is a tie");

            // Let the user decide whether to replay or exit the program
            System.out.println("Enter '1' to play again, or '0' to exit : ");
            int exitCode = userInput.nextInt();
            if (exitCode == 0)
                return;
        }
    }

    /**
     * The result functions print the result to the console while incrementing the appropriate counter
     * @param opponent: the random selection made by the opponent (rock, paper or scissors)
     * @return: The return value is used to increment the win counter
     */
    private static int Win(String opponent)
    {
        System.out.println("Your opponent has chosen " + opponent);
        System.out.println("You win this round.");
        return 1;
    }

    private static int Lose(String opponent)
    {
        System.out.println("Your opponent has chosen " + opponent);
        System.out.println("You lose this round.");
        return 1;
    }

    private static int Tie(String opponent)
    {
        System.out.println("Your opponent has chosen " + opponent);
        System.out.println("This round is a tie.");
        return 1;
    }
}
