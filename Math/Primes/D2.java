// Approach-B: Optimized Sieve

import java.util.*;

public class D2 {

    static List<Integer> simpleSieve(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
       
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // remove even numbers
        for (int i = 4; i <= limit; i += 2) {
            isPrime[i] = false;
        }

        // process only odd numbers
        for (int i = 3; i * i <= limit; i += 2) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i <= limit; i += 2) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }


    static void segmentedSieve(long L, long R) {
        if (L < 2) L = 2;            // handle 2 separately later

        // STEP-1: Generate primes till sqrt(R)
        int limit = (int)Math.sqrt(R);
        List<Integer> primes = simpleSieve(limit);

        // STEP-2: Optimized segmented sieve
        int size = (int)((R - L) / 2) + 1;     // store only odd numbers
        boolean[] isPrime = new boolean[size];
        Arrays.fill(isPrime, true);

        for (int p : primes) {
            if (p == 2) continue;    // skip 2 because evens ignored

            long start = Math.max(
                    1L * p * p,
                    ((L + p - 1) / p) * 1L * p
            );

            if ((start & 1) == 0) {   // make start odd
                start += p;
            }

            for (long j = start; j <= R; j += 2L * p) {  // mark only odd multiples
                isPrime[(int)((j - L) / 2)] = false;     // skip even numbers in indexing
            }
        }

        // print 2 separately
        if (L <= 2 && R >= 2) {
            System.out.print(2 + " ");
        }

        // make L odd
        if ((L & 1) == 0) {
            L++;
        }

        // process only odd numbers
        for (long num = L; num <= R; num += 2) {
            if (isPrime[(int)((num - L) / 2)]) {
                System.out.print(num + " ");
            }
        }
    }

    public static void main(String[] args) {
        segmentedSieve(100, 150);
    }
}