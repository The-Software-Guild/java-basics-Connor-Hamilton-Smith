import java.util.*;

/**
 *  A class that prints a genetic background from a random selection of dog breeds
 *  Each breed is given a random percentage which sums to 100%
 */
public class DogGenetics
{
    public static void main (String[] args)
    {
        Random rGen = new Random();

        String name = GetInput();
        String[] dogBreeds = GetDogBreeds();

        System.out.println(name + " is: ");
        // Loop through each breed in the array, each one is assigned a percentage and then printed to the console
        int remainingPercentage = 100;
        for (int i = 0; i < dogBreeds.length; i++)
        {
            if (i < dogBreeds.length - 1)
            {
                // Randomly select a percentage for the current breed out of the remaining percentage pool
                int percentage = rGen.nextInt(remainingPercentage);
                // Subtract the used percentage, reducing the pool for the next iteration
                remainingPercentage -= percentage;
                // Print the percentage and breed name to the console
                System.out.println(percentage + "% " + dogBreeds[i] + ",");
            }
            // On the final iteration, the percentage is simply the remaining percentage
            else
            {
                System.out.println(remainingPercentage + "% " + dogBreeds[i]);
            }
        }
    }

    /**
     * A function containing a scanner object used to get the dog's name from the user
     * @return: Returns the name received from user input
     */
    private static String GetInput()
    {
        Scanner userInput = new Scanner(System.in);

        System.out.print("What is your dog's name? : ");
        String name = userInput.nextLine();

        return name;
    }

    /**
     * A function selects 5 random dog breeds from a pre-determined list
     * @return: Returns an array containing the selected breeds
     */
    private static String[] GetDogBreeds()
    {
        Random rGen = new Random();

        // Create and populate a list of potential dog breeds
        List<String> dogBreeds = new ArrayList<>();
        dogBreeds.add("St. Bernard");
        dogBreeds.add("German Shepherd");
        dogBreeds.add("Labrador Retriever");
        dogBreeds.add("Basenji");
        dogBreeds.add("Pembroke Welsh Corgi");
        dogBreeds.add("Border Collie");
        dogBreeds.add("Siberian Husky");
        dogBreeds.add("Dalmatian");
        dogBreeds.add("Dachshund");
        dogBreeds.add("Whippet");

        // Randomly select 5 unique dog breeds
        String[] selectedBreeds = new String[5];
        for (int i = 0; i < 5; i++)
        {
            // Select a random dog breed from the list
            int breedsSize = dogBreeds.size();
            String breed = dogBreeds.get(rGen.nextInt(dogBreeds.size()));
            // Remove the selected dog breed from the list, so it is not duplicated
            dogBreeds.remove(breed);
            // Add the selected dog breed to a new array
            selectedBreeds[i] = breed;
        }

        return selectedBreeds;
    }
}