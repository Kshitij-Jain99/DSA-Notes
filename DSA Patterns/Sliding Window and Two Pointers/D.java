//1004. Max Consecutive Ones III: https://leetcode.com/problems/max-consecutive-ones-iii/description/
//HW:1,2 Part

import java.util.List;

public class D {
   //Approach-1:Brute Force
   //TC = O(n^2), SC = O(1)    
    public int longestOnes1(int[] nums, int k){
       int n = nums.length;
       int maxLen = 0;

       for(int i =0; i<n; i++){
        int zeros = 0;
        for(int j =i; j<n; j++){
            if(nums[j] == 0) zeros++;
            if(zeros <= k){
                int len = j -i +1;
                maxLen = Math.max(maxLen, len);
            } else break;
        }
       }
       return maxLen;
    }

    //Approach-2: Sliding Window
    //TC = O(2.N), SC = O(1)
    public int longestOnes2(int[] nums, int k){
        int maxLen = 0;
        int left = 0, right = 0;
        int zeros = 0;

        while(right < nums.length){
            if(nums[right] == 0) zeros++;
        
        //shrink the window from left if zeros exceed k
        while(zeros > k){ // l run 
            if(nums[left] == 0) zeros--;
        left++;
        }
        //now window has at most k zeros
        int len = right - left + 1;
        maxLen = Math.max(maxLen, len);
        right++;
    }
    return maxLen;
  }

  
    //Approach-3: Optimal Sliding Window
    //TC = O(N), SC = O(1)
     public int longestOnes3(List<Integer> nums, int k){
        int left = 0, right = 0;
        int zeros = 0;
        int maxLen = 0;

        while(right < nums.size()){
            if(nums.get(right) == 0) zeros++;
            if(zeros > k){
                if(nums.get(left) == 0) zeros--;
                left++;
            }
            if(zeros <= k){
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        return maxLen;
     }
}
