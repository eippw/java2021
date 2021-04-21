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

        WorldHappiness happyData = new WorldHappiness(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders();

        Matrix helper = new Matrix();
        helper.print(headers);
        helper.print(tdata);
        helper.print(ndata);
        
        System.out.println("Connor's schnozz");
        
        
        System.out.println("Please give a country name:");
        
        String countryName = sctxt.nextLine();
        
        
        
        // get a count of how many rows have countryName in tdata
        // also find index of the starting row
        int count = 0;
        int startIndex = -1;
        boolean foundStart = false;
        
        for (int r = 0; r < tdata.length; r++){
            for (int c = 0; c < tdata[0].length; c++){
                if (tdata[r][c].equalsIgnoreCase(countryName) && foundStart == false){
                    // ASSERT: found the first row w the proper country, now record row and count
                    foundStart = true;
                    count++;
                    startIndex = r;
                } else if (tdata[r][c].equalsIgnoreCase(countryName)){
                    count++;
                }
            }
        }
        
        System.out.println("Found " + count + " matching ");
        
        double sum = 0;
        int maxLength = startIndex + count;
        for (int r = startIndex; r < ndata.length; r++){
            for (int c = 0; c < ndata[2].length; c++){
                if (startIndex <= maxLength){
                    sum += ndata[r][c];
                }
            }
        }
        
        
        
        
        double ave = sum / count;
        
        System.out.println("The average happiness over the course of " + count +
            " years in " + countryName + " is: " + ave );
    }
}
