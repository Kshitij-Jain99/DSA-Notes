// SPF Prime Factorization using Linear Sieve:
// TC = O(N), SC = O(N)

import java.util.*;

public class C2 {
    static List<Integer> primes = new ArrayList<>();

    // Builds SPF array using Linear Sieve
    static int[] buildSPF(int n) {
        
        int[] spf = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (spf[i] == 0) {      // Detect Prime
                spf[i] = i;
                primes.add(i);
            }

            for (int p : primes) {  // Mark composites
                if (i * p > n)      // Stop if out of range
                    break;

                spf[i * p] = p;     // smallest prime factor of i*p is p

                if (p == spf[i])    // Critical condition for linear complexity - every composite gets marked exactly once
                    break;
            }
        }
        return spf;
    }

    // Factorizes x using SPF array
    static List<Integer> factorize(int x, int[] spf) {
        List<Integer> factors = new ArrayList<>();

        while (x != 1) {
            factors.add(spf[x]);
            x /= spf[x];
        }

        return factors;
    }
}
