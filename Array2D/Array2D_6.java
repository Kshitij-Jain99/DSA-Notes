  //WHEN THE CONDITION IS INSIDE FOR LOOP IN BOTTOM AND LEFT BOUNDARY CONDITIO, WE GET ERROR:
  /*If the if conditions were placed inside the for loops, it would mean that the loop would start executing even if the boundary condition is not met, resulting in printing incorrect or out-of-bounds elements.
For example, let's take the case of the "bottom boundary" loop. If the condition startRow != endRow is not met and this condition is placed inside the loop, the loop would still execute and try to print elements even though there's no valid row to print from. This could result in an "ArrayIndexOutOfBoundsException" or incorrect output. */
public class Array2D_6 {
    public static void printSprial(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow<= endRow && startCol <= endCol) {
            //top  --startcol to endcol, startrow fix
            for(int j=startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j]+ " " );
            }

            //right boundary--startrow+1 to endrow, endcolm fix
            for( int i=startRow+1; i<=endRow; i++) {    
                System.out.print(matrix[i][endCol]+ " " );
            }

            //bottom boundary-- endcol-1 to startcol., endrow stays same
            for(int j=endCol-1; j>=startCol; j--){
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j]+ " " );
            }

            //left boundary-- endrow-1 to startrow-1; keeping startcol. constant
            for(int i=endRow-1; i>=startRow+1; i++){
                 if(startCol == endCol) {
                    break;
                 }
                   System.out.print(matrix[i][startCol]+ " " );
            }

            startCol++;
            startRow++;
            endCol--;
            endRow--;

        }
        System.out.println();

    }
    
    public static void main(String args[]){
        int matrix[][] = { {1,2,3,4,},
                           {5,6,7,8},
                           {9,10,11,12},
                           {13,14,15,16}};
        printSprial(matrix);
    }
    
}
