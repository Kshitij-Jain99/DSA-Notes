//Koko Eating Bananas (B.S. on Answer Space)

public class L {
        //Approach-1:Brute Force
        // TC = O(max(v) * N), SC = O(1)
        /*
        1. Find maximum pile → upper bound of speed
        2. Try every k = 1 → max, For each k, compute total hours for current speed(k)
        3. Return first k where time ≤ h 
        */    
        public static int findMax1(int[] v){
            int maxi = Integer.MIN_VALUE;
            for(int i = 0; i<v.length; i++) maxi = Math.max(maxi, v[i]);
            return maxi;
        }

        public static int calculateTotalHours1(int[] v, int hourly){
            int totalH = 0;
            for(int i = 0; i<v.length; i++) totalH += Math.ceil((double)v[i]/ (double)(hourly));
            return totalH;
        }

        public static int minimumRateToEatBananas1(int[]v, int h){
            int maxi = findMax1(v);  //find maximum value in array
            
            for(int i = 1; i<= maxi; i++){  //find min. value of h
                int reqTime = calculateTotalHours1(v, i);
                if(reqTime <= h) return i; //found the minimum rate
            }

            return maxi;  //dummy return statement
        }


        //Approach-2: BS on answer space
        // TC = O(N * log(max(v)), SC = O(1)
        /*
            1. If speed k is too slow, time > h
               If speed k is fast enough, time ≤ h
            2. This is a monotonic behavior, So we can apply Binary Search
               Smaller k → more time, Larger k → less time  
        */
        public static int findMax2(int[]v){
            int maxi = Integer.MIN_VALUE;
            for(int i = 0; i<v.length; i++) maxi = Math.max(maxi, v[i]);
            return maxi;
        }

        public static int calculateTotalHours2(int[] v, int hourly){
            int totalH = 0;
            for(int i = 0; i<v.length; i++) totalH += Math.ceil((double)v[i]/ (double)(hourly));
            return totalH;
        }

        public static int minimunRateToEatBananas2(int[] v, int h){
            int low = 1, high = findMax2(v);
            while(low <= high){
                int mid = (low + high)/2;
                int totalH = calculateTotalHours2(v, mid);

                if(totalH <= h) high = mid-1; // try smaller speed
                else low = mid + 1;           // increase speed
            }
            return low;
            
        }



        //Approach-3: BS + Early Break Optimization
        // TC = O(N * log(max(v))) (better constant), SC = O(1)
        /*
        1. Early Exit optimization:
           -> If current speed k is too slow, we already know it's invalid
           -> No need to check remaining piles 
        2. Integer Math Instead of Math.ceil:
           -> Removes floating-point operations, Avoids type casting, Faster and safer
           -> Ceil value calculation using pure integer math:
              ceil(a / b) = (a + b - 1) / b
           -> Math.ceil() internally uses double, Double operations are slower than integer ops   
        3. These reduces average TC, because Many bad k values exit early.        
        */
        public static int findMax3(int[]v){
            int maxi = Integer.MIN_VALUE;
            for(int i = 0; i<v.length; i++) maxi = Math.max(maxi, v[i]);
            return maxi;
        }

        public static int calculateTotalHours3(int[] v, int hourly, int h){
            int totalH = 0;

            for(int i = 0; i < v.length; i++){
                totalH += (v[i] + hourly - 1) / hourly;

                if(totalH > h) return totalH; // early exit
            }
            return totalH;
        }

        public static int minimumRateToEatBananas3(int[] v, int h){
            int low = 1, high = findMax3(v);

            while(low <= high){
                int mid = low + (high - low)/2;
                int totalH = calculateTotalHours3(v, mid, h);

                if(totalH <= h) high = mid - 1;
                else low = mid + 1;
            }
            return low;
        }

}
