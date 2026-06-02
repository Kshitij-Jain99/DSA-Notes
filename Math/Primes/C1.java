// Linear Sieve(Euler Sieve):
// TC = O(N), SC = O(N)

import java.util.*;

public class C1 {
    static List<Integer> primes = new ArrayList<>();

    public static int[] linearSieve(int n) {
        int[] lp = new int[n + 1];       // lp[x] = lowest prime factor of x
        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {     
                lp[i] = i;
                primes.add(i);
            }

            for (int p : primes) {
                if (p > lp[i] || i * p > n)   // stop if exceeds limit
                    break;

                lp[i * p] = p;
                }
        }
        return lp;
    }
}