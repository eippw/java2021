import java.io.IOException;
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
        helper.print(headers);
        helper.print(tdata);
        helper.print(ndata);
        
        System.out.println("Connor's schnozz");
    }

}
