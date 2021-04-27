import java.io.IOException;
import java.util.*;
public class HappinessTester {

    public static void main(String[] args) throws IOException {

        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java HappinessTester ../data/world-happiness-report.csv out.txt");
            System.exit(0);
        }

        String in_fn = args[0]; // input filename
        String out_fn= args[1]; // output report filename

        WorldHappiness happyData = new WorldHappiness(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders();

        Matrix helper = new Matrix();
        //helper.print(headers);
        //helper.print(tdata);
        //helper.print(ndata);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a country name: ");
        String countryName = scanner.nextLine();
        
        int count = happyData.getCount(countryName);
        int startIndex = happyData.getStartIndex(countryName);
        double meanLadder = happyData.getCountryMeanLadder(countryName);
        
        System.out.println("Found " + count + " rows for " + countryName);
        System.out.println("The starting row index for " + countryName + " is: " + startIndex);
        System.out.printf("The mean Ladder score for %s is %.4f\n",countryName, meanLadder);
        
        
        // TODO:
        // add code to ask the user if they want to see all the data 
        // from all the counties. If they do, the bonus section of code should
        // execute
        
        // bonus
        String[] allCountries = happyData.getCountries();
        for (int i = 0; i < allCountries.length; i++) {
            double mean = happyData.getCountryMeanLadder(allCountries[i]);
            System.out.printf("The mean Ladder score for %s is %.4f\n",allCountries[i], mean);
        }
        
    }

}