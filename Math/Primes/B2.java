// SPOJ. TDKPRIME - Finding the Kth Prime: https://www.spoj.com/problems/TDKPRIME/

import java.io.*;

public class B2 {

    // Approach-1(0.82 time, 166 MB Mem.): Using sieve
    // TC = O(NloglogN), SC = O(N)
    static final int LIMIT = 90000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] queries = new int[t];  // store all kth prime requests
        int maxK = 0;                // store largest query
        for (int i = 0; i < t; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            maxK = Math.max(maxK, queries[i]);
        }

        boolean[] composite = new boolean[LIMIT + 1];  // sieve array
        int[] primes = new int[maxK + 1];              // store primes by idx
        int count = 0;
        primes[++count] = 2;

        for (int i = 3; i <= LIMIT && count < maxK; i += 2) {
            if (!composite[i]) {
                primes[++count] = i;
                // avoid integer overflow
                if (1L * i * i <= LIMIT) {
                    for (long j = 1L * i * i; j <= LIMIT; j += 2L * i) {
                        composite[(int) j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k : queries) {
            sb.append(primes[k]).append('\n');
        }
        System.out.print(sb);
    }
}
