//Aggressive Cows (B.S. on Answer Space: Max(Min) Variant)
import java.util.Arrays;

public class Q {

        //Approach-1: Brute Force
        // TC: O(NLogN + N*limit), SC: O(1)
        /*
            1. Sort stalls
            2. Try every possible minimum distance from 1 → max distance
            3. For each distance, check: Can we place all cows with at least this gap?
        */
        public static boolean canWePlace1(int[] stalls, int dist, int cows){
            int n = stalls.length;
            int cntCows = 1;            //no. of cows placed, first cow placed at stalls[0]
            int last = stalls[0];       //pos. of last placed cow
            for(int i = 1; i<n; i++){
                if(stalls[i] - last >= dist){
                    cntCows++;
                    last = stalls[i];
                }
                if(cntCows >= cows) return true;
            }
            return false;
        }

        public static int aggressiveCows1(int[] stalls, int k){
            int n = stalls.length;
            Arrays.sort(stalls);

            int limit = stalls[n-1] - stalls[0]; // Max Distance
            for(int i = 1; i <= limit; i++){ 
                if(canWePlace1(stalls, i, k) == false) return (i-1);
            }
            return limit;
        }
        
        

        //Approach-2: BS on answer space: min(max) or max(min)
        //TC = O(N.LogN + N * log(range), SC = O(1)
        public static boolean canWePlace2(int[] stalls, int dist, int cows){
            int n = stalls.length;
            int cntCows = 1; 
            int last = stalls[0];
            for(int i = 1; i<n; i++){
                if(stalls[i] - last >= dist){
                    cntCows++;
                    last = stalls[i];
                }
                if(cntCows >= cows) return true;
            }
            return false;
        }

        public static int aggressiveCows2(int[] stalls, int k){
            int n = stalls.length;
            Arrays.sort(stalls);

            int low = 1, high = stalls[n-1] - stalls[0];
            while(low <= high){
                int mid = (low + high)/2;
                if(canWePlace2(stalls, mid, k) == true) low = mid +1;
                else high = mid-1;
            }    
            return high;
        }
}
