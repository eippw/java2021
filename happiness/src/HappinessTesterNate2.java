import java.io.IOException;
import java.util.Scanner;
public class HappinessTesterNate2 {


    public static void main(String[] args) throws IOException {


        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java HappinessTester ../data/world-happiness-report.csv out.txt");
            System.exit(0);
        }


        String in_fn = args[0]; // input filename
        String out_fn= args[1]; // output report filename


        WorldHappinessNate2 happyData = new WorldHappinessNate2(in_fn, out_fn);
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
        double lifeexp = happyData.getCountryMeanLifeExpectancy(countryName);
        double percep = happyData.getCountryMeanCorruptionPerception(countryName);
        
        System.out.println("Found " + count + " rows for " + countryName);
        System.out.println("The starting row index for " + countryName + " is: " + startIndex);
        System.out.printf("The mean Ladder score for %s is %.4f\n",countryName, meanLadder);
        System.out.println("The mean life expectancy at birth for "+countryName+" is: "+lifeexp);
        System.out.println("The mean perception of corruption for "+countryName+" is: "+percep);
      
      // ADD YOUR CODE HERE AND USE THE tdata, ndata matrices to calculate your averages
        /*
        double ladavg=0;
        int count=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter a country:");
        String country=scan.nextLine();
        for(int i=0;i<tdata.length;i++){
            if(tdata[i][0].equals(country)){
                count++;
               ladavg=ndata[i][2]+ladavg;
            }
        */
        
        String[] allCountries = happyData.getCountries();
        for (int i = 0; i < allCountries.length; i++) {
            double mean = happyData.getCountryMeanLadder(allCountries[i]);
            System.out.printf("The mean Ladder score for %s is %.4f\n",allCountries[i], mean);
        
        }

        // TODO:
        // ask the user if they want to see the happiest country and 
        // the most unhappy country based on the mean Ladder Score. 
        // If yes, print out the country with the greatest mean ladder score 
        // and the country with the lowest mean ladder score
        
        System.out.println("Would you like to see the happiest and unhappiest countries?");
        String ans = scanner.nextLine();
        String[] allCountries = happyData.getCountries();
        String hhappy="";
        String lhappy="";
        double happiest = happyData.getCountryMeanLadder(allCountries[0]);
        double unhappiest= happyData.getCountryMeanLadder(allCountries[0]);
        if(ans.equalsIgnoreCase("yes")){
            for (int i = 1; i < allCountries.length-1; i++) {
                //System.out.println(current);
                double mean = happyData.getCountryMeanLadder(allCountries[i]);
                if (mean>happiest){
                happiest = mean;
                hhappy=allCountries[i];
                }else if(mean<unhappiest){
                unhappiest = mean;
                lhappy = allCountries[i];
                }
            
            System.out.println("Happiest: "+hhappy);
            System.out.println("Unhappiest: "+lhappy);
            }
        
        }
        

         
        }
        

    
    }
        
        
