/**
 * This program will read the data from the world-happiness-report.csv 
 * and move the data into several different multidimensional arrays that 
 * we will work with to analyze the data provided.
 *
 */


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class WorldHappinessJake implements DataSet {
    private String[][] tdata;   // text data
    private double[][] ndata;   // numeric data
    private String[] headers;     // column headers/names
    private String infn;
    private String outfn;
    private final int MAX_STRINGS = 1;
    private final int MAX_NUMBERS = 10;

    public WorldHappinessJake(String infn, String outfn) throws IOException {
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

    public String[] getHeaders() {
        return headers;
    }

    // Retrun a count of all lines, including the header line
    private int countLines(boolean show) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(infn));
            int lines = 0;
            while (reader.readLine() != null) 
                lines++;
            reader.close();
            if (show) {
                System.out.println("lines = " + lines);
            }
            return lines;
        } catch(IOException e) {
            System.out.println("Error getting a line count in file: " + infn);
            return -1;
        }
    }

    // Popluate the column header array and if show is true, display column headers
    // PRE: header is the first row of data from the input file
    private void showHeaderRow() {
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

    // A valid row of data is: all cells have some data, no empty data cells allowed for now
    private boolean isAllDataValid(String[] data) {
        boolean isValid = false;
        boolean notDone = true;
        for (int i = 0; i < data.length && notDone; i++) {
            // sanity check overkill :)
            if (data[i] != null && !data[i].isEmpty() && data[i].length() != 0 && !data[i].equals("")) {
                isValid = true;
            } else  {
                isValid = false;
                notDone = false; // meaning we are done with this loop! :))
            }
        }
        return isValid;
    }

    // TODO: jaketwigs: build another version that uses Arrays and/or ArrayLists with either
    //       String data, or a custom Class to represent the data
    //       Goal for you is to only loop through the file once and then process with
    //       the list you create
    //
    // populate the member multidimensional arrays with all valid data
    // Yessir Mr Billy ICE Eipp it will be done - Daddy T
    private void initData() throws IOException {

        final int lineCount = countLines(false);

        FileReader fin = new FileReader(infn);
        Scanner src = new Scanner(fin); 
        src.useDelimiter(", *"); 

        // strip off header line an move cursor into first line of real data
        String header = src.nextLine(); 
        headers = header.split(",", -1);

        //showHeaderRow(); // call if interested 

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

        fin.close(); 

        int newRowSize = lineCount - invalidCount - 1; // minus one to not count the header row :)
        tdata = cleanTextArray(ta, newRowSize);
        ndata = cleanNumArray(da, newRowSize);
        //showTextData(tdata);
        //showNumData(ndata);
 
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

    // TODO: last method we will build. No description at this time of the project
    public void describe() {
        
    }
    

    /**
     * PRE: tdata has been populated
     * @return an array with all the distinct country name in it appearing
     * exactly once
     */
    public String[] getCountries() {
        int count = 1; // start at 1 for last row to be added at the end
        String curName = tdata[0][0];
        for (int row = 1; row < tdata.length; row++) {
           if (!tdata[row - 1][0].equals(tdata[row][0])) {
               count++;
           } 
        }
        
        String[] distinct = new String[count];
        int distinctIndex = 0;
        for (int row = 1; row < tdata.length; row++) {
           if (!tdata[row - 1][0].equals(tdata[row][0])) {
               //System.out.println("debug: " + countries[row][0]);
               distinct[distinctIndex] = tdata[row-1][0];
               distinctIndex++;
           } 
        }
        distinct[distinct.length-1] = tdata[tdata.length-1][0];
        return distinct;
    }
    
    
    // TODO
    /**
     * Return the mean value for the Ladder column data for a particular 
     * country
     * @param countryName The name of the country to get the mean Ladder score of
     * @reutun the average of the Ladder scores for a coutry or -1 if the country count is 0
     */
    public double getCountryMeanLadder(String countryName) {
        return 0.0;
    }
    
    
    // TODO
    /**
     * Get a count of how many rows have the country name in tdata
     * @param countryName The name of the country to get a count of 
     * @return the number of rows where the country name shows up
     */
    public int getCount(String countryName) {
        return 0;
    }
    
    // TODO
    /**
     * Get the starting index where the country name first shows up in tdata
     * @param countryName The name of the country to find the starting index for
     * @return the starting index or -1 if no starting index could be found
     */
    public int getStartIndex(String countryName) {
        return 0;
    }
        
}
