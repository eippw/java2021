import java.util.Scanner;
import java.io.*;

public class ReadFiles {
	private String[][] tdata; 	// text data
	private double[][] ndata;	// numeric data
	private String infn;
	private String outfn;
    private final int MAX_STRINGS = 1;
    private final int MAX_NUMBERS = 10;

	public ReadFiles(String infn, String outfn) throws IOException {
		this.infn = infn;
		this.outfn = outfn;
		initData();
	}

    public String[][] getTextData() {
        return tdata;
    }

    public double[][] getNumData() {
        return ndata;
    }

	public static void main(String[] args) 
		throws IOException {
		if (args.length != 2 || args[0] == null || args[1] == null) {
			System.out.println("Warning: you must include the input and output file names");
			System.exit(0);
		}
		String in_fn = args[0];
		String out_fn= args[1];
		ReadFiles reader = new ReadFiles(in_fn, out_fn);
	}

    // note: this also counts the header line...
    private int countLines(FileReader r, boolean show) {
        try {
            BufferedReader reader = new BufferedReader(r);
            int lines = 0;
            while (reader.readLine() != null) 
                lines++;
            reader.close();
            r.close();
            if (show) {
                System.out.println("lines = " + lines);
            }
            return lines;
        } catch(IOException e) {
            System.out.println("Error getting a line count in file: " + infn);
            return -1;
        }
    }

    // use if interested
    private void showHeaderRow(String header) {
		String[] headers = header.split(",", -1);
        System.out.println("headers.length == " + headers.length);
		for (int i = 0; i < headers.length; i++) {
            System.out.print(headers[i].length() + " :: ");
			if (headers[i] == null) {
				System.out.println("null");
			} else if (headers[i].isEmpty()) {
				System.out.println("isEmpty");
			} else if (headers[i].length() == 0) {
				System.out.println("lengthIsZero");
			} else {
				System.out.println(headers[i]);
			}
		}
    }

    // def of valid row of data is that all cells have some data in them, no empty data cells allowed for now
    private boolean isAllDataValid(String[] data) {
        boolean isValid = false;
        boolean notDone = true;
        for (int i = 0; i < data.length && notDone; i++) {
            if (data[i] != null && !data[i].isEmpty() && data[i].length() != 0 && !data[i].equals("")) {
                isValid = true;
            } else  {
                isValid = false;
                notDone = false; // meaning we are done with this loop! :))
            }
        }
        return isValid;
    }

    // populate the member multidimensional arrays with all valid data
	private void initData() throws IOException {

		final int lineCount = countLines(new FileReader(infn), false);

		FileReader fin = new FileReader(infn);
		Scanner src = new Scanner(fin); 
		src.useDelimiter(", *"); 

		String headerLine = src.nextLine(); // strip off header line an move cursor into first line of real data
        //showHeaderRow(headerLine); // use if you want to see column headers

        int curRow = 0;
        int invalidCount = 0;
        int validCount = 0;
        String[][] ta = new String[lineCount][MAX_STRINGS];;
        double[][] da = new double[lineCount][MAX_NUMBERS];

		while(src.hasNextLine() && curRow < lineCount) { 

			String raw = src.nextLine();
			String[] data = raw.split(",", -1);

			boolean validRow = isAllDataValid(data);
            if (validRow) {
                validCount++;
            } else {
                invalidCount++;
            }

			// if row of data has no missing values, fill the arrays proplerly
			if (validRow) {
                int curRowIdx = 0;
				for (int i = 0; i < data.length; i++) {
					if (i == 0) {
						ta[curRow][0] = data[0];
					} else {
						da[curRow][curRowIdx] = Double.parseDouble(data[i]);
                        curRowIdx++;
					}
				}
                curRow++;
			}

		}

        int newRowSize = lineCount - invalidCount - 1; // minus one to not count the header row :)
        tdata = cleanTextArray(ta, newRowSize);
        ndata = cleanNumArray(da, newRowSize);
        showTextData(tdata);
        showNumData(ndata);
 
		fin.close(); 
	}

    // remove the last invalidCount rows in a and return a new array
    // note: [][]a contains null or zero filled rows based at bottom of array due to the invalidRow count
    private String[][] cleanTextArray(String[][] a, final int ROWS) {
        String[][] t = new String[ROWS][MAX_STRINGS];
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[0].length; col++) {
                t[row][col] = a[row][col];
            }
        }
        return t;
    }

    // remove the last invalidCount rows in a and return a new array
    // note: [][]a contains null or zero filled rows based at bottom of array due to the invalidRow count
    private double[][] cleanNumArray(double[][] a, final int ROWS) {
        double[][] t = new double[ROWS][MAX_NUMBERS];
        for (int row = 0; row < t.length; row++) {
            for (int col = 0; col < t[0].length; col++) {
                t[row][col] = a[row][col];
            }
        }
        return t;
    }

    // use for debugging
    private void showTextData(String[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                System.out.print("[" + row + "][" + col + "] " + data[row][col] + "\t");
            }
            System.out.println();
        }
    }

    // use for debugging
    private void showNumData(double[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                System.out.print("[" + row + "][" + col + "] " + data[row][col] + "\t");
            }
            System.out.println();
        }
    }

}
