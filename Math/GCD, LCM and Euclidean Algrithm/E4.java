// CF. 1542C: Strange Function: https://codeforces.com/contest/1542/problem/C

class E4 {
    static final long MOD = 1_000_000_007L;

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


    // Approach: Prefix LCM Accumulation + Contribution Counting
    // TC ≈ O(log N), SC = O(1)
    static long strangeFunction(long n) {
        long answer = 0;
        long previousLCM = 1;

        for (long k = 2; previousLCM <= n; k++) {
            long currentLCM = lcm(previousLCM, k);

            if (currentLCM > n) currentLCM = n + 1;   // Prevent overflow
            long count = (n / previousLCM) - (n / currentLCM);

            answer = (answer + (count % MOD) * (k % MOD)) % MOD;
            previousLCM = currentLCM;
        }
        return answer;
    }
}
