import java.util.*;
import java.io.IOException;
public class HappinessTesterIvy{


    public static void main(String[] args) throws IOException{


        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java HappinessTester ../data/world-happiness-report.csv out.txt");
            System.exit(0);
        }


        String in_fn = args[0]; // input filename
        String out_fn= args[1]; // output report filename


        WorldHappinessIvy happyData = new WorldHappinessIvy(in_fn, out_fn);
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
        double lifeExpectancy = happyData.getCountryMeanLifeExpectancy(countryName);
        double corruption = happyData.getCountryMeanCorruptionPerception(countryName);
        
        System.out.println("Found " + count + " rows for " + countryName);
        System.out.println("The starting row index for " + countryName + " is: " + startIndex);
        System.out.printf("The mean Ladder score for %s is %.4f\n",countryName, meanLadder);
        System.out.printf("The mean life expectancy for %s is %.4f\n",countryName, lifeExpectancy);
         System.out.printf("The mean corruption for %s is %.4f\n",countryName, corruption);
        
        System.out.print("do you want to see all countries values: (y/n): ");
        String yn = scanner.nextLine();
        if (yn.equalsIgnoreCase("y")) {
        
            // bonus
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
        
        System.out.println("Would you like to see the happiest and least happiest countries, based on ladder score? (y/n):");
        String response = scanner.nextLine();
        if(response.equalsIgnoreCase("y")){
            double max = 0;
            String maxS = "";
            double min = 100;
            String minS = "";
            String[] allCountries = happyData.getCountries();
            
            for(int i = 0; i < allCountries.length; i++){
                 double mean = happyData.getCountryMeanLadder(allCountries[i]);
                    if(mean > max){
                        max = mean;
                        maxS = allCountries[i];
                    }
                    if(mean < min){
                        min = mean;
                        minS = allCountries[i];
                    }
                }
           System.out.println("Happiest Country is: " + maxS + " With the mean ladder score of: " + max);
            System.out.println("Least Happiest Country is: " + minS + " With the mean ladder score of: " + min);
        }

    }



      // ADD YOUR CODE HERE AND USE THE tdata, ndata matrices to calculate your averages
      /*
           double sum = 0;
           int count = 0;
           double avg = 0;
           
            for(int row = 273; row < 287; row++){
              
              sum += ndata[row][3];  
              count++;
            }
            avg = sum/count;
            System.out.println("Average ladder score for Canada is :" + avg);
           
        */
        
          /**
          for(int row = 0; row > tdata; row++){
              for(int col = 0; col > tdata; col++){
                  
              }
          }
          **/




}



