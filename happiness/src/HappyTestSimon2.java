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


        WorldHappiness happyData = new WorldHappiness(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders();


      // ADD YOUR CODE HERE AND USE THE tdata, ndata matrices to calculate your average
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter name of desired country: ");
      String country = scan.nextLine();
      int count = 0;
      double ave = 0;
      for (int i = 0; i < tdata.length; i++) {
          if (tdata[i][0].equals(country)) {
              ave += ndata[i][2];
              count++;
          }
      }
      System.out.println("Average = " + (ave / count));
      
    }
}