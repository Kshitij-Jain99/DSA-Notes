// Longest Substring With At Most K Distinct Characters: https://takeuforward.org/plus/dsa/problems/longest-substring-with-at-most-k-distinct-characters
import java.util.*;

public class F {
    
    // Approach-1: Brute Force
    // TC = O(n^2.log(k)), SC = O(k); k distinct characters
    public int lengthOfLongestSubstringKDistinct1(String s, int k){
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> freq = new HashMap<>();
            for(int j = i; j < s.length(); j++){
                freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0) + 1);

                if(freq.size() > k) break;

                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }

    
    // Approach-2: Sliding Window
    // TC = O(2N + K), SC = O(K)
public int lengthOfLongestSubstringKDistinct2(String s, int k){
        if(k == 0 || s.length() == 0) return 0;

        int l = 0, r = 0;
        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }


    // Approach-3: Optimal Sliding Window
    // TC = O(n + k), SC = O(k)
    public int lengthOfLongestSubstringKDistinct3(String s, int k){
        if(k == 0 || s.length() == 0) return 0;

        int l = 0, maxLen = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for(int r = 0; r < s.length(); r++){
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            if(freq.size() > k){
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                if(freq.get(s.charAt(l)) == 0){
                    freq.remove(s.charAt(l));
                }
                l++;
            }
            if(freq.size() <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return maxLen;
    }
}
