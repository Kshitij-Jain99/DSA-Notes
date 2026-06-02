// LC. 2470. Number of Subarrays With LCM Equal to K: https://leetcode.com/problems/number-of-subarrays-with-lcm-equal-to-k/description/?utm_source=chatgpt.com

import java.util.HashMap;
import java.util.Map;

public class E2 {
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }


    // Approach-1: Incremental Rolling LCM + Divisibility Pruning
    // TC = O(N^2.logV)(Faster in Runtime), SC = O(1)
    public int subarrayLCM1(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int currentLCM = 1;
            for (int j = i; j < n; j++) {
                currentLCM = lcm(currentLCM, nums[j]);

                if (currentLCM > k) break;          // LCM already too large
                if (k % currentLCM != 0) break;     // Cannot ever become k later
                if (currentLCM == k) count++;
            }
        }
        return count;
    }


    // Approach-2: Distinct LCM State Compression
    // TC = O(N * distinctLCMs * logV), SC = O(distinctLCMs)
    public int subarrayLCM2(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> prev = new HashMap<>();               // Previous distinct LCM states

        for (int num : nums) {
            Map<Integer, Integer> curr = new HashMap<>();
            int selfLCM = num;                                     // Start new subarray

            if (k % selfLCM == 0) curr.merge(selfLCM, 1, Integer::sum);

            for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {  // Extend previous subarrays
                int oldLCM = entry.getKey();
                int freq = entry.getValue();
                int newLCM = lcm(oldLCM, num);

                if (newLCM > k) continue;                    // Pruning
                if (k % newLCM != 0) continue;

                curr.merge(newLCM, freq, Integer::sum);
            }
            answer += curr.getOrDefault(k, 0);   // Add all valid subarrays with LCM == k 
            prev = curr;
        }
        return answer;
    }
}
