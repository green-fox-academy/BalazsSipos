import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        // - Create (dynamically) a two dimensional array
        //   with the following matrix. Use a loop!
        //
        //   1 0 0 0
        //   0 1 0 0
        //   0 0 1 0
        //   0 0 0 1
        //
        // - Print this two dimensional array to the output
        int[][] matrix = new int[4][4];
        for(int i = 0;i<4;i++) {
            //matrix[i] = {};
            for(int j = 0;j<4;j++) {
                if(i==j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        //System.out.println(Arrays.toString(matrix));

        for(int i = 0;i<matrix.length;i++) {
            //matrix[i] = {};
            for(int j = 0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
