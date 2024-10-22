/*Placing the if conditions outside the for loops is a design choice to prevent loops from running when the conditions for traversal are not met. This avoids printing elements that are not part of the current traversal direction and helps to prevent errors. */
public class Array2D_6B {
    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top -- startcol to endcol, startrow fix
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right boundary -- startrow+1 to endrow, endcolm fix
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom boundary -- endcol-1 to startcol, endrow stays same
            if (startRow != endRow) {
                for (int j = endCol - 1; j >= startCol; j--) {
                    System.out.print(matrix[endRow][j] + " ");
                }
            }

            // left boundary -- endrow-1 to startrow+1; keeping startcol constant
            if (startCol != endCol) {
                for (int i = endRow - 1; i > startRow; i--) {
                    System.out.print(matrix[i][startCol] + " ");
                }
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        printSpiral(matrix);
    }
}
