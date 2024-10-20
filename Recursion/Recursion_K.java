public class Recursion_K {
    public static int power(int x, int n) {
        if(n==0){   //base case
            return 1;
        }
        // int xnm1 power(x, n-1);
        // int xn = x*xnm1;
        // return xn;
        return x*power(x,n-1); //simplified code in 1 line
    }

public static void main(String args[]){
    System.out.println(power(2,5));

    }
}