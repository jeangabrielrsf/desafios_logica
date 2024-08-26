import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Integer> snailOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(matrix[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(matrix[row][endCol]);
            }

            if (startRow < endRow && startCol < endCol) {
                for(int col = endCol - 1; col > startCol; col--) {
                    result.add(matrix[endRow][col]);
                }

                for (int row = endRow; row > startRow; row--) {
                    result.add(matrix[row][startCol]);
                }

            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
            {1,  2,  3},
            {4,  5,   6},
            {7,  8,   9}
        };
        int[][] matrix2 = {
                {1,  2,  3,  1},
                {4,  5,   6, 4},
                {7,  8,   9,  7},
                {7,  8,  9,  7}
        };


        System.out.println(snailOrder(matrix1));
        System.out.println(snailOrder(matrix2));
    }
}