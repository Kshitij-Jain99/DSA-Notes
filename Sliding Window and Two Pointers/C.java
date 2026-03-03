//3. Longest Substring Without Repeating Characters: https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class C {
   
    //Approach-1: Brute Force:
   // TC = O(N^2), SC = O(N)
       static int lengthOfLongestSubstring1(String str) {
        if (str.length() == 0)
            return 0;

        int maxLen = 0;

        for (int i = 0; i < str.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (seen.contains(ch)) {
                    break; // duplicate found
                }
                seen.add(ch);
                maxLen = Math.max(maxLen, j - i + 1); // update max length
            }
        }

        return maxLen;
    }

    //Approach-2: Sliding Window with HashSet
   // TC = O(2.N), SC = O(N)
   static int lengthOfLongestSubstring2(String str){
    
    if(str.length() == 0) return 0;
    
    int maxans = Integer.MIN_VALUE;
    Set<Character> set = new HashSet<>();
    int l = 0;
    for(int r = 0; r< str.length(); r++){
        if(set.contains(str.charAt(r))){
           while(l < r && set.contains(str.charAt(r))){
            set.remove(str.charAt(l));
            l++;
           }
        }
        set.add(str.charAt(r));

        maxans = Math.max(maxans, r-l+1);
    }
    return maxans;
   }

    //Approach-3: Optimized Sliding Window with HashMap(Index Jumping)
   // TC = O(N), SC = O(N)
   static int lengthOfLongestSubstring3(String s){
    if(s.length() == 0) return 0;

    HashMap<Character, Integer> mpp = new HashMap<>();
    int left = 0, right = 0, len = 0;
    int n = s.length();
    while(right < n){
        if(mpp.containsKey(s.charAt(right))) 
           left = Math.max(mpp.get(s.charAt(right)) + 1, left);

        mpp.put(s.charAt(right), right);
        len = Math.max(len, right-left+1);
        right++;
    }
    return len;
   }

   //Approach-4(Most optimal): Sliding Window with Fixed size array(ASCII indexing)
   // TC = O(N), SC = O(1)
       public int lengthOfLongestSubstring4(String s) {
         int n = s.length(), maxLen = 0;
        int[] lastIndex = new int[128];  //ASCII
       

        int start = 0;  
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            start = Math.max(start, lastIndex[c]);
            maxLen = Math.max(maxLen, i - start + 1);
         
            lastIndex[c] = i + 1;
        }
        return maxLen;
    }
}
