//904. Fruit Into Baskets: https://leetcode.com/problems/fruit-into-baskets/
import java.util.*;

public class E {
    //Approach-1: Brute Force
    //TC = O(n^2), SC = O(3)
    public int totalFruit(int[] fruits){
        int maxLen = 0;
        int n = fruits.length;

        for(int i = 0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i; j<n; j++){
                set.add(fruits[j]);

                if(set.size() <= 2){
                    int len = j-i+1;
                    maxLen = Math.max(maxLen, len);
                } else{
                    break;
                }
            }
        }
        return maxLen;
    }

    //Approach-2: Sliding Window
    //TC = O(2.N), SC = O(3)
      public int totalFruit2(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }

        int maxLen = 0;
        int left = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while (basket.size() > 2) {
                int leftFruit = fruits[left];
                basket.put(leftFruit, basket.get(leftFruit) - 1);
                
                if (basket.get(leftFruit) == 0) {
                    basket.remove(leftFruit);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    //Approach-3: Optimized Sliding Window
    //TC = O(N), SC = O(3)
    public int totalFruit3(int[] fruits) {
    int left = 0, right = 0, maxLen = 0;
    Map<Integer, Integer> basket = new HashMap<>();

    while (right < fruits.length) {
        // Add current fruit to the basket
        basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

        // Shrink the window only when the constraint is violated
        if (basket.size() > 2) {
            // Remove fruit at left
            basket.put(fruits[left], basket.get(fruits[left]) - 1);
            if (basket.get(fruits[left]) == 0) {
                basket.remove(fruits[left]);
            }
            left++;
        }

        // Valid window (size <= 2), update maxLen
        if (basket.size() <= 2) {
            maxLen = Math.max(maxLen, right - left + 1);
        }

        right++;
    }

    return maxLen;
}


    //Appraoch-4: Optimized Two-Variable Sliding Window
    //TC = O(N), SC = O(1)
   public int totalFruit4(int[] fruits) {
    int n = fruits.length;
    int lastFruit = -1, secondLastFruit = -1;
    int lastFruitCount = 0;  // count of lastFruit in a row
    int currMax = 0, max = 0; // current and overall max window sizes

    for (int fruit : fruits) {
        if (fruit == lastFruit || fruit == secondLastFruit) {
            currMax++;
        } else {
            currMax = lastFruitCount + 1;  // restart window
        }

        if (fruit == lastFruit) {
            lastFruitCount++;
        } else {
            lastFruitCount = 1;
            secondLastFruit = lastFruit;
            lastFruit = fruit;
        }

        max = Math.max(max, currMax);
    }

    return max;
}
}
