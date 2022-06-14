import java.util.Scanner;

public class HealthyHearts
{
    public static void main (String[] args)
    {
        // Get the user input
        int age = GetInput();

        // Calculate maximum heart rate
        int maximumHeartRate = 220 - age;

        // Calculate target heart rate
        int targetHeartRate_Low = Math.round(maximumHeartRate * 0.5f);
        int targetHeartRate_High = Math.round(maximumHeartRate * 0.85f);

        System.out.println("Your maximum heart rate is: " + maximumHeartRate + " beats per minute.");
        System.out.println("Your target heart rate is: " + targetHeartRate_Low + " to " + targetHeartRate_High + " beats per minute.");
    }

    private static int GetInput()
    {
        Scanner userInput = new Scanner(System.in);
        int age = 0;

        for (;;)
        {
            boolean success = true;

            System.out.print("What is your age? : ");
            try
            {
                // Get the user's age from the scanner
                age = userInput.nextInt();
                userInput.nextLine();
            }
            // If the above failed then the input value was not an integer
            catch (Exception e)
            {
                System.out.println("Only integer values will be accepted.\n");
                success = false;
            }
            // Only allow values within a certain age range
            if (age < 0 || age > 150)
            {
                System.out.println("Age outwith acceptable range.\n");
                success = false;
            }

            // Only break out of the loop if the input was correctly formatted, otherwise receive a new input
            if (success)
                break;
        }

        return age;
    }
}
