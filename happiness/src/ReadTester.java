import java.io.IOException;
public class ReadTester {

    public static void main(String[] args) throws IOException {
        if (args.length != 2 || args[0] == null || args[1] == null) {
            System.out.println("Warning: you must include the input and output file names");
            System.out.println("Example: java ReadTester wh.csv out.txt");
            System.exit(0);
        }
        String in_fn = args[0];
        String out_fn= args[1];
        ReadFiles reader = new ReadFiles(in_fn, out_fn);
        String[][] tdata = reader.getTextData();
        double[][] ndata = reader.getNumData();
    }

}
