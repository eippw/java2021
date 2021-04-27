import java.util.*;
import java.io.IOException;
public class HappyTestChris2 {

    public static void main(String[] args) throws IOException {

        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java HappinessTester ../data/world-happiness-report.csv out.txt");
            System.exit(0);
        }


        String in_fn = args[0]; // input filename
        String out_fn= args[1]; // output report filename
        
        WorldHappinessChris2 happyData = new WorldHappinessChris2(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders(); 
        
        Matrix helper = new Matrix();
        helper.print(headers);
        //helper.print(tdata);
        //helper.print(ndata);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a country name: ");
        String countryName = scanner.nextLine();
        
        
        int count = happyData.getCount(countryName);
        int startIndex = happyData.getStartIndex(countryName);
        double meanLadder = happyData.getCountryMeanLadder(countryName);


        System.out.println("Count: " + count);
        System.out.println("Start index is: " + startIndex);
        System.out.println("Mean ladder score for " + countryName + " is " + meanLadder);

        System.out.print("Would you like to see all countries Y/n: ");
        String y_n = scanner.nextLine();
        if (y_n.substring(0,1).equalsIgnoreCase("n")) {
            System.exit(0);
        }
        
        // bonus
        String[] allCountries = happyData.getCountries();
        for (int i = 0; i < allCountries.length; i++) {
            double mean = happyData.getCountryMeanLadder(allCountries[i]);
            System.out.printf("The mean Ladder score for %s is %.4f\n",allCountries[i], mean);
        }


    }


}
