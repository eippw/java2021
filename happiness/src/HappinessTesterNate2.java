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


        WorldHappiness happyData = new WorldHappiness(in_fn, out_fn);
        String[][] tdata = happyData.getTextData();
        double[][] ndata = happyData.getNumData();
        String[] headers = happyData.getHeaders();


      // ADD YOUR CODE HERE AND USE THE tdata, ndata matrices to calculate your averages
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
    
        
            
        }
        double average=ladavg/count;
        
        System.out.println("Average ladder score for "+country+": "+average);
        

    }


}