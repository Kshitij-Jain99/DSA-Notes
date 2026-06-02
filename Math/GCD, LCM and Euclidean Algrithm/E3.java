// CF. 1152C. Neko does Maths: https://codeforces.com/problemset/problem/1152/C 

class E3 {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }


    // Approach-1: Divisor Enumeration + GCD Invariant Optimization
    // TC = O(sqrt(|b-a|) * logV), SC = O(1)
    static long minimumK(long a, long b) {
        if (a > b) {                 // Ensure a <= b as algo uses (b-a)
            long temp = a;
            a = b;
            b = temp;
        }
        if (a == b) return 0;        // Already equal, LCM(a,b) = a, already minimum

        long diff = b - a;           // Difference Invariant
        long bestK = 0;              // Initially, no operation
        long minLCM = lcm(a, b);

        for (long d = 1; d * d <= diff; d++) {    // Enumerate divisors
            if (diff % d != 0)  continue;
            long[] result1 = processDivisor(d, a, b, bestK, minLCM);  // First divisor
 
            bestK = result1[0];
            minLCM = result1[1];

            long other = diff / d;              // Second divisor
            if (other != d) {
                long[] result2 =
                        processDivisor(other, a, b, bestK, minLCM);
                bestK = result2[0];
                minLCM = result2[1];
            }
        }
        return bestK;
    }

    static long[] processDivisor(long d, long a, long b, long bestK, long minLCM) {
        long k = (d - a % d) % d;     // Smallest k making a divisible by d

        long newA = a + k;
        long newB = b + k;
        long currentLCM = lcm(newA, newB);

        if (currentLCM < minLCM) {        // Better LCM found
            minLCM = currentLCM;
            bestK = k;
        }

        else if (currentLCM == minLCM) {  // Same LCM -> choose smaller k
            bestK = Math.min(bestK, k);
        }
        
        return new long[]{bestK, minLCM};
    }
}
