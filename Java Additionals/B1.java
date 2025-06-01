// BigInteger & BigDecimal: Basic Operations
 
import java.math.BigDecimal;
import java.math.BigInteger;

public class B1 {
    public static void main(String[] args){
        BD();
        BI();
    }

    static void BI(){
        int a = 30;
        int b = 67;

        // these are static: Convert int/long to BigInteger
        BigInteger A = BigInteger.valueOf(33);
        BigInteger B = BigInteger.valueOf(21324324); // This has to be in range of Integer
        
        int c = B.intValue(); // Convert BigInteger to int
        
        // This uses constructor
        BigInteger C = new BigInteger("343232443242"); // This can be any size.

        //constants
        BigInteger D = BigInteger.ZERO;  //.ONE or .TEN

        //operations
        BigInteger sum = A.add(B);
        BigInteger product = B.multiply(C);
        BigInteger difference = B.subtract(A);
        BigInteger quotient = B.divide(A);
        BigInteger remainder = B.remainder(A);
        
        if(C.compareTo(A) > 0) {
            System.out.println("C is greater than A");
        } 

        System.out.println(product);
    }

    static void BD(){
        double x = 0.03;
        double y = 0.04;
        double ans = y-x;
        System.out.println(ans); // 0.0100..........002

        BigDecimal X = new BigDecimal("0.03");
        BigDecimal Y = new BigDecimal("0.04");
        BigDecimal ans2 = Y.subtract(X);    
        System.out.println(ans2); // 0.01 -> Accurate

        BigDecimal a = new BigDecimal("45354534535354534.234124543");
        BigDecimal b = new BigDecimal("2342342234.234234234");

        //operations
        System.out.println(b.add(a));
        System.out.println(b.multiply(a));
        System.out.println(b.subtract(a));

        //Constants
        BigDecimal con = BigDecimal.ZERO; // .ONE or .TEN
    }
}
