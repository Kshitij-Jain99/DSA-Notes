public class F2 {
    //n=2,3 have no solution
   public static boolean isSafe(char board[][], int row, int col) {
     //j--> chnages; here col--> ek cell ko check 
     //vertical up-- same column, row decreases
     for(int i=row-1; i>=0; i--){
       if(board[i][col] == 'Q') {
           return false;
       }
   
     }
     
     //diagoenal left up
     for(int i= row-1, j= col-1; i>=0 && j>=0; i--, j--) {
       if(board[i][j] == 'Q') {
           return false;
       }
     }
   
   
     //diagonal right up
     for(int i= row-1, j= col+1; i>=0 && j<board.length; i--,j++) {
       if(board[i][j] == 'Q') {
           return false;
       }
     }
     return board[row][col] != 'Q';
   } 
       
   public static void nQueens(char board[][], int row) {
       //base case
       if(row== board.length) {
        //    printBoard(board);
              count++;
           return;
       }
       //column loop
       for(int j=0; j<board.length; j++){
           if(isSafe(board, row, j)) {
               board[row][j] = 'Q'; //queen ko baitha diya
               nQueens(board, row+1);  //Recursion function call- queen ko recursively baitha diya next row par
               board[row][j] = 'x'; //Backtracking-dobara sein quuen ko hata ke jagah khali
           }
       
          
       }
     }
     //print board
     public static void printBoard(char board[][]) {
       System.out.println("----------Chess Board--------"); //println
       for(int i=0; i<board.length; i++ ) {
           for(int j=0; j<board.length ; j++) {
               System.out.print(board[i][j]+ " ");  //print
           }
           System.out.println();   //println
       }
     }
   
     static int count = 0;  // modified
       public static void main(String args[]) {
           int n=5;
           char board[][] = new char[n][n];
           //initialize
           for(int i =0; i<n; i++){
               for(int j =0; j<n; j++) {
                   board[i][j] = 'x';
               }
           }
   
           nQueens(board, 0);  //call-board and row
           System.out.println("total ways to solve n queens= " + count);
       }
   }
   