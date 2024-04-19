/**Class: Poem
 * @author Derron Pierre
 * @version 1.0
 * Course: ITEC 2140 Spring 2024
 * Written: April 17, 2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NumberStats {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "Book1.csv";
        String outputFile = "stats.txt";

        try {
            // Open the input file for reading
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Variables to store statistics
            double sum = 0;
            double lowest = Double.MAX_VALUE;
            double highest = Double.MIN_VALUE;
            int count = 0; // Counter for number of values

            String line;

            // Read each line from the input file
            while ((line = bufferedReader.readLine()) != null) {
                double number = Double.parseDouble(line);
                // Update sum
                sum += number;
                count++; // Increment count
                // Update lowest and highest values
                if (number < lowest) {
                    lowest = number;
                }
                if (number > highest) {
                    highest = number;
                }
            }

            // Close input file reader
            bufferedReader.close();

            // Calculate average
            double average = sum / count;

            // Open the output file for writing
            FileWriter fileWriter = new FileWriter(outputFile);

            // Write statistics to the output file
            fileWriter.write("The sum of the numbers is: " + sum + "\n");
            fileWriter.write("The lowest number is: " + lowest + "\n");
            fileWriter.write("The highest number is: " + highest + "\n");
            fileWriter.write("The average of the numbers is: " + average + "\n");

            // Close output file writer
            fileWriter.close();

            // Print a message to indicate successful completion
            System.out.println("Statistics written to " + outputFile);
        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
    }
}
