public class Recursion_KL {
    public static int power(int x, int n) {
        if(n==0){   //base case
            return 1;
        }
        // int xnm1 power(x, n-1);
        // int xn = x*xnm1;
        // return xn;
        return x*power(x,n-1); //simplified code in 1 line
    }

    public static int optimizedPower(int a, int n){
        if(n==0) {
            return 1;
        }
        // int halfPowerSq = optimizedPower(a, n/2)*optimizedPower(a, n/2);- this give O(n) T.C.
        //T.C.-O(logn)
        int halfPower= optimizedPower(a,n/2);  
        int halfPowerSq = halfPower*halfPower;
        //n is odd
        if( n%2 !=0 ){
            halfPowerSq = a*halfPowerSq;

        }
        return halfPowerSq;
    } 

public static void main(String args[]){
    System.out.println(power(2,5));
    System.out.println(optimizedPower(2, 5));

    }
}