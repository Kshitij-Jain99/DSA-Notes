// LC. 2447. Number of Subarrays With GCD Equal to K: https://leetcode.com/problems/number-of-subarrays-with-gcd-equal-to-k/description/

import java.util.HashMap;
import java.util.Map;

class F2 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    // Approach-1(6 ms): Incremental Rolling GCD + Divisibility Pruning
    // TC = O(N^2.logV) (Faster in Runtime), SC = O(1)
    // Incrementally updating subarray GCD and pruning impossible states early.
    static int subarrayGCD1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int currentGCD = 0;
            for (int j = i; j < n; j++) {
                currentGCD = gcd(currentGCD, nums[j]);      // Rolling gcd update

                if (currentGCD < k)  break;                // GCD can never increase again
                if (currentGCD % k != 0) break;            // Future gcds can never become k
                if (currentGCD == k) count++;
            }
        }

        return count;
    }


    // Approach-2(6 ms): Distinct GCD State Compression
    // TC = O(N * distinctGCDs * logV), SC = O(distinctGCDs)
    // Compressing identical gcd states instead of storing all subarrays.
    static int subarrayGCD2(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> prev = new HashMap<>();        // Previous distinct GCD states

        for (int num : nums) {
            Map<Integer, Integer> curr = new HashMap<>();
            int selfGCD = num;                              // Start new subarray

            if (selfGCD % k == 0) curr.merge(selfGCD, 1, Integer::sum);

            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {    // Extend previous subarrays
                int oldGCD = entry.getKey();
                int freq = entry.getValue();
                int newGCD = gcd(oldGCD, num);

                if (newGCD < k) continue;                        // Impossible to become k later
                if (newGCD % k != 0) continue;
                curr.merge(newGCD, freq, Integer::sum);
            }
            answer += curr.getOrDefault(k, 0);      // Add all valid subarrays with gcd == k
            prev = curr;
        }
        return answer;
    }
}
