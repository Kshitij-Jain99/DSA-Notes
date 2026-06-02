// Prefix/Suffix LCM:
import java.util.*;

class E1 {
    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }


    // Approach-1: Prefix/Suffix Array
    // TC = O(3N), SC = O(2N)
    // Explicitly storing Left and Right info.
    static long[] lcmExceptSelf(long[] arr) {
        int n = arr.length;

        long[] prefix = new long[n];
        long[] suffix = new long[n];
        long[] answer = new long[n];

        // Build prefix LCM
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) prefix[i] = lcm(prefix[i - 1], arr[i]);

        // Build suffix LCM
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) suffix[i] = lcm(suffix[i + 1], arr[i]);

        // Compute answer
        for (int i = 0; i < n; i++) {
            if (i == 0) answer[i] = suffix[1];                   // Remove first element
            else if (i == n - 1) answer[i] = prefix[n - 2];      // Remove last element
            else answer[i] = lcm(prefix[i - 1], suffix[i + 1]);  // Middle elements
        }
        return answer;
    }


    // Approach-2: Rolling suffix
    // TC = O(N), SC = O(1)
    // Storing left info. and computing right info dynamically.
    static long[] lcmExceptSelf2(long[] arr) {
        int n = arr.length;
        long[] answer = new long[n];

        // Build prefix LCM directly into answer[]
        answer[0] = arr[0];
        for (int i = 1; i < n; i++) answer[i] = lcm(answer[i - 1], arr[i]);

        // Rolling suffix LCM
        long suffixLCM = arr[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) answer[i] = answer[i - 1];      // Remove last element
            else if (i == 0) answer[i] = suffixLCM;         // Remove first element
            else answer[i] = lcm(answer[i - 1], suffixLCM); // Middle elements

            suffixLCM = lcm(suffixLCM, arr[i]);             // Update suffix LCM
        }

        return answer;
    }
}