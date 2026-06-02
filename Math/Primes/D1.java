// Approach-A: Segmented Sieve
import java.util.*;

public class D1 {
    static List<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }


    static void segmentedSieve(long L, long R) {
        // STEP-1: Generate all primes till sqrt(R)    
        int limit = (int)Math.sqrt(R);
        List<Integer> primes = simpleSieve(limit);  // [2 3 5 7 11] 

        // STEP-2: Segmented sieve    
        boolean[] isPrime = new boolean[(int)(R - L + 1)];
        Arrays.fill(isPrime, true);

        for (int p : primes) {       // mark composites
            long start = Math.max(   // first multiple inside range
                    1L * p * p,
                    ((L + p - 1) / p) * 1L * p
            );

            for (long j = start; j <= R; j += p) { // Marks all multiples of p
                isPrime[(int)(j - L)] = false;
            }
        }

        // 1 is not prime
        if (L == 1) {
            isPrime[0] = false;
        }

        // print primes
        for (long i = L; i <= R; i++) {
            if (isPrime[(int)(i - L)]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        segmentedSieve(100, 130);
    }
}