public class MatrixTester {
    
    public static void main(String[] args) {
        
        int[][] md =   { {3,4,7,1,8,4}, {8,5,1,3,9,6}, {2,7,2,1,4,1},
                         {9,6,7,2,3,2}, {3,5,6,7,4,5}, {1,4,3,9,1,7} };
        
        Matrix matrix = new Matrix();
        matrix.print(md);
        
        int rowSums = matrix.sumAllRows(md);
        System.out.println("The sum of all rows is: " + rowSums);
        
        int[] rowSum = new int[md.length]; // array to hold all row sums :)
        for (int i = 0; i < rowSum.length; i++) {
            rowSum[i] = matrix.sumRow(md, i);
        }
        
        // print the row sums stored in my rowSum array
        for (int i = 0; i < rowSum.length; i++) {
            System.out.println("The sum of row " + i + " is: " + rowSum[i]);
        }
    }
}
