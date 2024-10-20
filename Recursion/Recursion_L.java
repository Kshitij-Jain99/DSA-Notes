public class Recursion_L {
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
     public static void main(String[] args) {
     int a=2;
     int n=5;
     System.out.println(optimizedPower(a, n));
     }
}
