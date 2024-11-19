import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Test for Step 1
        Plant test = new Plant("Stinging Nettle,65,anti-inflammatory and culinary");
        System.out.println("test plant:\n" + test + "\n\n");

        // Step 2: Declare and initialize variables
        ArrayList<Plant> plants = new ArrayList<>();
        Scanner fileScanner = null;

        try {
            // Step 2: Connect input stream to file
            fileScanner = new Scanner(new FileInputStream("Forage.csv"));

            // Step 2: Loop through file lines
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                try {
                    // Step 3: Create Plant objects and store in ArrayList
                    Plant plant = new Plant(line);
                    plants.add(plant);
                } catch (IllegalArgumentException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'Forage.csv' not found.");
        } finally {
            // Step 2: Close the input stream
            if (fileScanner != null) {
                fileScanner.close();
            }
        }

        // Step 3: Print contents of ArrayList
        System.out.println("Loaded Plants:");
        for (Plant plant : plants) {
            System.out.println(plant);
            System.out.println();
        }
    }
}