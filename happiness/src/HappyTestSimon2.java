import java.io.IOException;
import java.util.*;
public class HappyTestSimon2 {


    public static void main(String[] args) throws IOException {


        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java HappinessTester ../data/world-happiness-report.csv out.txt");
            System.exit(0);
        }

        String in_fn = args[0]; // input filename
        String out_fn= args[1]; // output report filename

        WorldHappinessSimon2 happyData = new WorldHappinessSimon2(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders();
        
        Matrix helper = new Matrix();
        helper.print(headers);
        //helper.print(tdata);
        //helper.print(ndata);

        // ADD YOUR CODE HERE AND USE THE tdata, ndata matrices to calculate your average
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name of desired country: ");
        String country = scan.nextLine();
        
        int count2 = happyData.getCount(country);
        int startIndex = happyData.getStartIndex(country);
        double meanLadder = happyData.getCountryMeanLadder(country);
        double meanLife = happyData.getCountryMeanLifeExpectancy(country);
        double meanCor = happyData.getCountryMeanCorruptionPerception(country);
        
        System.out.println("Found " + count2 + " rows for " + country);
        System.out.println("The starting row index for " + country + " is: " + startIndex);
        System.out.printf("The mean Ladder score for %s is %.4f\n",country, meanLadder);
        System.out.printf("The mean Life Expectancy for %s is %.4f\n",country, meanLife);
        System.out.printf("The mean Corruption Perception for %s is %.4f\n",country, meanCor);

        System.out.println("Do you want to see all countries Y/n? ");
        String ans = scan.nextLine();
      
        String[] allCountries = happyData.getCountries();
        if (ans.equalsIgnoreCase("y")) {
            for (int i = 0; i < allCountries.length; i++) {
                double mean = happyData.getCountryMeanLadder(allCountries[i]);
                System.out.printf("The mean Ladder score for %s is %.4f\n",allCountries[i], mean);
            }
        }
        
        System.out.println("Do you want to see the happiest and least happy countries Y/n? ");
        String ans2 = scan.nextLine();
        if (ans2.substring(0,1).equals("n")) {
            System.exit(0);
        }
        
        String happiest = "";
        double meanMost = 0;
        for (int i = 0; i < allCountries.length - 1; i++) {
            if (meanMost < happyData.getCountryMeanLadder(allCountries[i])) {
                meanMost = happyData.getCountryMeanLadder(allCountries[i]);
                happiest = allCountries[i];
            }
        }
        System.out.println("The country with the Highest mean ladder score is " + happiest + ": " + meanMost);
        
        String leastHappy = "";
        double meanLeast = 100;
        for (int i = 0; i < allCountries.length - 1; i++) {
            if (meanLeast > happyData.getCountryMeanLadder(allCountries[i])) {
                meanLeast = happyData.getCountryMeanLadder(allCountries[i]);
                leastHappy = allCountries[i];
            }
        }
        System.out.println("The country with the lowest mean ladder score is: " + leastHappy + ": " + meanLeast);
    }
}