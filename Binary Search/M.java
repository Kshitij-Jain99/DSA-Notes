//Minimum days to make M bouquets (B.S. on Answer Space)

public class M {

    // Approach-1: Brute Force
    // TC = O((max(arr) - min(arr) + 1)* N), SC = O(1)
    /*
     1. We are running a loop to check our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer, we will call the possible() function.
     2. Guess a day (day) and check: “Can I make at least m bouquets by this day?”
     */
        public static boolean possible1(int[] arr, int day, int m, int k){
            int n = arr.length;
            int cnt = 0;
            int noOfB = 0;                  //counting number of bouquets
            
            for(int i = 0; i<n; i++){ 
                if(arr[i] <= day) cnt++;    //arr[i] has already bloomed
                else {                      //arr[i] has not bloomed yet
                    noOfB += cnt/k;         // Handle when sequence breaks
                    cnt = 0;                // Reset cnt
                }
            }
            noOfB += cnt/k;                 // Handle last continuous sequence
            return noOfB >= m;
        }

        public static int roseGarden1(int[] arr, int k, int m){
            int n = arr.length;
            if((long)m * k > n) return -1;            // impossible case(total flowers needed > available)
            
            int mini = Integer.MIN_VALUE, maxi = Integer.MAX_VALUE;
            for(int i = 0; i<n; i++) {  
                mini = Math.min(mini, arr[i]);
                maxi = Math.max(maxi, arr[i]);
            }

            for(int i = mini; i <= maxi; i++){   // working on answer space
                if(possible1(arr, i, m, k)) return i;
            }
            return -1;
        }

        

        // Approach-2: BS on answer space
        // TC = O((log((max(arr) - min(arr) + 1) * N), SC = O(1)
        public static boolean possible2(int[] arr, int day, int m, int k){
            int n = arr.length;
            int cnt = 0;
            int noOfB = 0;

            for(int i = 0; i<n; i++){ 
                if(arr[i] <= day) cnt++;
                else{
                    noOfB += cnt/k;
                    cnt = 0;
                }
            }
            noOfB += cnt/k;
            return noOfB >= m;
        }

        public static int roseGarden2(int[] arr, int k, int m){
            int n = arr.length;
            if((long) m*k > n) return -1; 

            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
            for(int i = 0; i<n; i++){
                mini = Math.min(mini, arr[i]);
                maxi = Math.max(maxi, arr[i]);
            }
            int low = mini, high = maxi;
            while(low <= high){
                int mid = (low + high)/2;
                if(possible2(arr, mid, m, k)) high = mid -1;
                else low = mid + 1;
            }
            return low;  // Minimum day → FIRST TRUE → return low
        }


        /*
            Important Binary Search Pointer:
            1. Every binary search problem falls into one of these:
               A. Exact Match: Find target element
               B. First TRUE: Minimum valid answer
               C. Last TRUE: Maximum valid answer
            2. EXACT MATCH (Classic Binary Search)
               -> Use when: Array is sorted, Need to find a specific element
               -> low → explore right, high → explore left
               -> No concept of valid/invalid
               -> End condition: low > high → element not found
            3. FIRST TRUE (Lower Bound / Minimum Answer): Only valid for monotonic problems
               -> F F F F T T T T
                          ↑ answer (first TRUE)
               -> low → moves toward first TRUE, high → moves toward last FALSE
               -> Final state: high = last FALSE, low  = first TRUE(answer)   
               -> So, return low
            4. LAST TRUE (Upper Bound / Maximum Answer): Only valid for monotonic problems
               -> T T T T F F F
                        ↑ answer (last TRUE)
               -> low → moves toward first FALSE, high → moves toward last TRUE
               -> Final state: low  = first FALSE, high = last TRUE(ANSWER)
               -> So, return high                              
        */
}
