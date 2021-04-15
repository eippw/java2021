import java.util.Scanner;
import java.io.*;

public class ReadFiles {
	private String[][] tdata; 	// text data
	private double[][] ndata;	// numeric data
	private String infn;
	private String outfn;

	public ReadFiles(String infn, String outfn) throws IOException {
		this.infn = infn;
		this.outfn = outfn;
		initData();
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

	private void initData() throws IOException {

		FileReader fin = new FileReader(infn);
		Scanner src = new Scanner(fin); 

		int lineCount = 0;


BufferedReader reader = new BufferedReader(new FileReader(infn));
int lines = 0;
while (reader.readLine() != null) lines++;
reader.close();
System.out.println("lines = " + lines);





		fin = new FileReader(infn);
		src.useDelimiter(", *"); 
		String headerLine = src.nextLine();

		/*
		String[] headers = headerLine.split(",", -1);
		for (int i = 0; i < headers.length; i++) {
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
		*/


		while(src.hasNextLine()) { 

			int curRow = 0;
			tdata = new String[lineCount][1];;
			ndata = new double[lineCount][9];

			String raw = src.nextLine();
			//System.out.println(raw);
			String[] data = raw.split(",", -1);
			boolean validRow = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i] == null) {
					//System.out.print("null");
				} else if (data[i].isEmpty()) {
					//System.out.print("isEmpty");
				} else if (data[i].length() == 0) {
					//System.out.print("lengthIsZero");
				} else {
					validRow = true;
					//System.out.print(data[i]);
				}
			}
			//System.out.println();

			// fill the String array and the Numerical array
			if (validRow) {

				System.out.println(curRow);

				for (int i = 0; i < data.length; i++) {
					if (i == 0) {
						tdata[curRow][i] = data[i];
					}
					if (i != 0) {
						ndata[curRow][i-1] = Double.parseDouble(data[i]);
					}
				}
			}
			curRow++;



			/*
			if(src.hasNextDouble()) { 
				double tmp = src.nextDouble();
				System.out.print("double: " + tmp);
			} else if (src.hasNextInt()) {
				int tmp = src.nextInt();
				System.out.print("int: " + tmp);
			} else { 
				String tmp = src.next();  
				System.out.print("String: " + tmp);
			} 
			*/
		}

 
		fin.close(); 

		return ;

	}


}



