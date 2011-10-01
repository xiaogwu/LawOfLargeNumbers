/* Xiao G. Wu
 * CS111A - Assignment 6
 * 09/28/2011
 */

import java.text.DecimalFormat;

/** This class explores the theorem that if you perform the same experiment a large number of times, the average of the results should be close to the expected value.  In this case we are using coin tosses so the expected value should be around 50% */

public class LawOfLargeNumbers {

    /** Main method
     *  @params args Command line argument for the number of coin toss
     */

    public static void main(String[] args) {
        int numberOfTosses = 0; // Number of Tosses to perform
        double average = 0.0; // Expected value

        DecimalFormat averageFormatter = new DecimalFormat("#0%"); // Decimal Formatter for average value percentage

        if (args.length > 0) { // If command line argument specified
            try {
                numberOfTosses = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { // Argument specified is not a number
                System.err.println("Argument must be an integer"); // If argument is not a number provide warning
                System.exit(1);
            }
        } else { // If command line argument not specified we assume one million tosses
            System.out.println("Number of coin tosses unspecified, assuming 1000000 tosses");
            numberOfTosses = 1000000;
        }
        // Call manyCoinTosses method to get the average of the number of coin tosses
        average = manyCoinTosses(numberOfTosses);

        System.out.printf("Average value of %d tosses is ", numberOfTosses); // Print number of coin tosses performed
        System.out.println(averageFormatter.format(average)); // Specify average in percentage
    }
    
    /** Coin toss method returns a boolean, true is heads, fails is tails */

    public static boolean coinToss() {
        double flip = Math.random();
        if (flip < .50) // tails
            return false;
        else // heads
           return true; 
    }

    /** Many coin tosses method returns average percentage of heads based on number of tosses specified
     * @params numberOfTosses Number of Tosses
     */

    public static double manyCoinTosses(int numberOfTosses) {
        if (numberOfTosses == 0) { // Check to make sure user doesn't specify zero tosses
            System.out.println("Can't specify zero tosses, please try again");
            return 0.0;
        }
        else {
            int accumulator = 0; // Keeps track of the number of heads
            for (int iterator = 1; iterator <= numberOfTosses; iterator++)            {
                if (coinToss()) { // If coinToss is true (heads) increment accumulator
                    accumulator++;
                }
            }
            return ((double) accumulator / numberOfTosses); // Return average
        }
    }
}
