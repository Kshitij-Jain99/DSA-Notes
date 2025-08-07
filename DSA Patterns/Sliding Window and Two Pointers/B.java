//1423. Maximum Points You Can Obtain from Cards: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/

public class B{
    //Approach-1: Sliding window(Optimal)
    //TC = O(2.k), SC = O(1)
    public int maxScore1(int[] card, int k){
        int n = card.length;
        int lSum = 0;
        for(int i = 0; i<k; i++) lSum += card[i];

        int maxSum = lSum;
        int rSum = 0;
        int r = n - 1;
        for(int i = k-1; i>=0; i--){
            lSum -= card[i];
            rSum += card[r];
            r--;
            maxSum = Math.max(maxSum, lSum + rSum);
        }
        return maxSum;
    }


    //Appraoch-2: Sliding window(Less Efficient)
    //TC = O(2.n), SC = O(1)
    /*
     1. After drawing 'k' card, 'cardPoints.length - k' cards remain in the array.
     2. Reframing Problem:
        - Choosing 'k' cards from beginning or end of the array such that the sum of rem. cards is minimized.
        - 'k' card(max. sum) and 'cardPoints.length - k' cards remain(min. sum)
     3. max. subarray of size 'k' sum = Total array sum - min. subarray sum of size 'n-k'
     */
    public int maxScore2(int[] cards, int k){
        int start = 0;  //mark start idx of subarray in consideration to track length 
        int winSum = 0;
        int n = cards.length;
        int winLen = n-k;
        int total = 0;

        for(int val: cards) total += val;

        int minWin = total; //initializing with max sum, it will store min. subarray sum
        if(k == n) return total;

        for(int i =0; i<n; i++){
            winSum += cards[i];
            int len = i - start + 1;
            
            if(len == winLen){
                minWin = Math.min(minWin, winSum);
                winSum -= cards[start];
                start++;
            }
        }
        return total - minWin;
    }
}