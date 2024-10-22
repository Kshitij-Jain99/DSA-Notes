import java.util.*;

public class Array2D_4 {
    public static void main(String args[]){
        int matrix[][] = new int [3][3];   //cells=row*column
        int n=3, m=3;              //we can use int n=matrix.length, m= matrix[0].length

        Scanner sc = new Scanner(System.in);
        for( int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                matrix[i][j] = sc.nextInt();  //accessing a particular cell and storing data from input

        }
    } 

    //output
    for( int i=0; i<n; i++) {
        for(int j=0; j<m; j++){
                System.out.print(matrix[i][j] + " ");
            }
        System.out.println() ;
        }       
   } 
}