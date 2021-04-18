public class Matrix {

    public void print(String[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                System.out.print("[" + row + "][" + col + "] " + data[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public void print(double[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                System.out.print("[" + row + "][" + col + "] " + data[row][col] + "\t");
            }
            System.out.println();
        }
    }

    
    public void print(int[][] md) {
        for (int[] row : md) {
            for (int e : row) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }
    }

    public void print(String[] a) {

        for(int i = 0; i < a.length; i++) {
            System.out.println("[" + i + "] \t" + a[i]);
        }

    }
    
    // TODO: return the to sum of all rows
    public int sumAllRows(int[][] md) {
        int sum = 0;
        for (int i = 0; i < md.length; i++) 
            sum += sumRow(md, i);
        return sum;
    }
    
    
    
    // TODO: return the sum of a particular row given in rowIndex
    //       make sure rowIndex is valid if not valid return -1
    public int sumRow(int[][] md, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= md.length)  
            return -1;
        
        int sum = 0;
        for (int col = 0; col < md[0].length; col++)
           sum += md[rowIndex][col]; 
        return sum;
    }
    

    // add two matrices and return a new "summed" matirx
    // ASSERT: m1 and m2 are exactly same size
    // ASSERT: the returned array is also the same size as m1 and m2
    public int[][] add(int[][] m1, int[][] m2) {
        
        // create the summed matrix of the correct size
        
       
       //summed[row][col] = m1[row][col] + m2[row][col];
        return new int[0][0];
       
    }
    

    // subtract two matrices and return a new "diff" matirx
    // ASSERT: m1 and m2 are exactly same size
    // ASSERT: the returned array is also the same size as m1 and m2
    public int[][] subtract(int[][] m1, int[][] m2) {
        
        return new int[0][0];
        
    }
    
}
