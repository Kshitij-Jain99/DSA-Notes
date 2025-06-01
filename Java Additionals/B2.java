// BigInteger & BigDecimal 
import java.math.BigInteger;

public class B2 {
    public static void main(String[] args){
        System.out.println(fact(233342));
    }

    static BigInteger fact(int num){
        BigInteger ans = new BigInteger("1");

        for(int i =2; i<= num; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }

}
