import java.util.*;
public class Array13{
        public static void maxSubarraySum(int numbers[] ) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        
        prefix[0] = numbers[0];                   //we started loop from 1 so we wrote this
        for(int i=1; i<prefix.length; i++) {
            prefix[i]= prefix[i-1] + numbers[i];
        }

            for(int i=0; i<numbers.length; i++) {
            int start =i;
            for(int j=i; j<numbers.length; j++) {
                int end = j;

                //WONT WORK:currSum = start == 0 ? prefix(end) : prefix(end) - prefix(start-1);
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1]; //start=0, so in that case we use ternary
                System.out.println(currSum);
                if(maxSum< currSum) { 
                    maxSum =currSum; 
                }
            }
        }
        System.out.println("max sum = " + maxSum);
    }
        public static void main(String args[]) {
            int numbers[] = {1,-2,6,-1,3};
            maxSubarraySum(numbers);
        }
    }