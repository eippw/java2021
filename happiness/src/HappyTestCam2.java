import java.io.IOException;
import java.util.*;
public class HappyTestCam2 {

    public static void main(String[] args) throws IOException {
        
        Scanner sctxt = new Scanner(System.in);
        
        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java HappinessTester ../data/world-happiness-report.csv out.txt");
            System.exit(0);
        }

        String in_fn = args[0]; // input filename
        String out_fn= args[1]; // output report filename

        WorldHappinessCam2 happyData = new WorldHappinessCam2(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders();

        Matrix helper = new Matrix();
        //helper.print(headers);
        //helper.print(tdata);
        //helper.print(ndata);
        
        
        System.out.println("Please give a country name:");
        
        String countryName = sctxt.nextLine();
        
        
        int count = happyData.getCount(countryName);
        int startIndex = happyData.getStartIndex(countryName);
        double meanLadder = happyData.getCountryMeanLadder(countryName);
        double meanExpectancy = happyData.getCountryMeanLifeExpectancy(countryName);
        double meanCorruption = happyData.getCountryMeanCorruptionPerception(countryName);
        
        System.out.println("Found " + count + " rows for " + countryName);
        System.out.println("The starting row index for " + countryName + " is: " + startIndex);
        System.out.printf("The mean Ladder score for %s is %.4f\n",countryName, meanLadder);
        System.out.printf("The mean life expectancy for %s is %.4f\n",countryName, meanExpectancy);
        System.out.printf("The mean Perception of Corruption for %s is %.4f\n",countryName, meanCorruption);
       
       System.out.println("Would you like to see all countries y/n");
       String y_n = sctxt.nextLine();
       
       if (y_n.equalsIgnoreCase("y")){
           String[] allCountries = happyData.getCountries();
            for (int i = 0; i < allCountries.length; i++) {
                double mean = happyData.getCountryMeanLadder(allCountries[i]);
                System.out.printf("The mean Ladder score for %s is %.4f\n",allCountries[i], mean);
            }
       }
       
       
       
        // TODO:
        // ask the user if they want to see the happiest country and 
        // the most unhappy country based on the mean Ladder Score. 
        // If yes, print out the country with the greatest mean ladder score 
        // and the country with the lowest mean ladder score
        System.out.println("Would you like to see the happiest and least happy countries? y/n ");
        String ans = sctxt.nextLine();
        
        
        String lHappy = "";
        String mHappy = "";
        
        if (ans.equalsIgnoreCase("y")){
            String[] allCountries = happyData.getCountries();
            double least = happyData.getCountryMeanLadder(allCountries[0]);
            double highest = happyData.getCountryMeanLadder(allCountries[0]);
            
            for (int i = 0; i < allCountries.length; i++){
                double mean = happyData.getCountryMeanLadder(allCountries[i]);
                
                // find lowest score
                if (mean < least){
                    least = mean;
                    lHappy = allCountries[i];
                }
                
                // find highest score
                if (mean > highest){
                    highest = mean;
                    mHappy = allCountries[i];
                }
            }
            System.out.println("The most happy country is: " + mHappy);
            System.out.println("The least happy country is: " + lHappy);
        }
        
        
       
       
        
    }
}