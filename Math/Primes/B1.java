
// Optimized Sieve(Odd only)
// TC = O(n log log n), SC = O(n/2)
import java.util.*;

public class B1 {

    // Returns list of all primes <= n
    public static List<Integer> sieve(int n) {

        List<Integer> primes = new ArrayList<>();

        if (n < 2) return primes;
        primes.add(2);           // Handle 2 separately

        // Only store odd numbers [1, 3, 5, 7...] at idx i = 0, 1, 2, 3...
        boolean[] isComposite = new boolean[(n >> 1) + 1];     // index i represents number (2*i + 1)
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {                 // Only odd i
            if (!isComposite[i >> 1]) {                       // if prime
                for (int j = i * i; j <= n; j += (i << 1)) {  // Skip even multiples => step = 2*i
                    isComposite[j >> 1] = true;
                }
            }
        }

        // Collect primes
        for (int i = 3; i <= n; i += 2) {
            if (!isComposite[i >> 1]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
