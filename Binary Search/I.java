// Find Peak Element (B.S. on 1D Arrays)

public class I {
    
    // Approach-1: Brute Force
    // TC = O(N), SC = O(1)
    public int findPeakElement1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Check left neighbor if exists
            boolean left = (i == 0) || (nums[i] >= nums[i - 1]);
            // Check right neighbor if exists
            boolean right = (i == n - 1) || (nums[i] >= nums[i + 1]);

            // If both conditions are true
            if (left && right) return i;
        }
        return -1;
    }


    // Approach-2: Binary Search:
    // TC = O(LogN), SC = O(1)
    public static int findPeakElement2(int[] nums) {
        int n = nums.length;

        // Edge cases
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Peak condition
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // Increasing slope → go right
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } 
            // Decreasing slope → go left
            else {
                high = mid - 1;
            }
        }

        return -1;
    }


    // Approach-3: Optimized Binary Search(Always move towards peak)
    // TC = O(LogN), SC = O(1)
    public int findPeakElement3(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid + 1]) { // on decreasing slope
                // Move to left half
                high = mid;
            } else {                        // nums[mid] <= nums[mid+1] on ascending slope
                // Move to right half
                low = mid + 1;
            }
        }

        // Return peak index (high or low both points to mid)
        return low;
    }
}
