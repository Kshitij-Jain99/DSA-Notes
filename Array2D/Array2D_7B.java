public class Array2D_7B {   //Time comp.:0(n)---optimized code
    public static int diagonalSum(int matrix[][]){
        int sum=0;
        for(int i=0; i<matrix.length;i++) {
            //pdiag.
            sum+=matrix[i][i];
            //sdiag.
            if(i != matrix.length-1-i)  //condition in which i is not equal to j
            sum+= matrix[i][matrix.length-i-1];
            //overalping condition for 3*3 is not covered so add one more condition
        }
       
        return sum;

    }
    public static void main(String args[]) {
        int matrix[][] ={{1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };
    System.out.println(diagonalSum(matrix));
    }
}
