// Minimum in Rotated Sorted Array (B.S. on 1D Arrays)

public class F {
    
    // Approach-1: Brute Force
    // TC = O(N), SC= O(1)
    public int findMin1(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    
    // Approach-2: Basic Binary Search
    // TC = O(logn), SC= O(1)
    public int findMin2(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } 
            // Right half is sorted
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }


    // Approach-3: Optimized Binary Search
    // TC = O(logn), SC= O(1)
    /*
        When current search space is already sorted, directly take nums[low] and break.
    */
    public int findMin3(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            // Optimization: already sorted
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            int mid = low + (high - low) / 2;

            // Left half sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } 
            // Right half sorted
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }

    
    // Approach-4: Variant(Duplicate handling)
    // TC = O(N), SC= O(1)
    public int findMin4(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Case 1: duplicates block decision
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                ans = Math.min(ans, nums[low]);
                low++;
                high--;
            }
            // Case 2: left half sorted
            else if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            }
            // Case 3: right half sorted
            else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }


    // Approach-5: Variant(Optimized Duplicate handling)
    // TC = O(N), SC= O(1)
    /*
    Instead of shrinking both sides (low++, high--), move only one pointer (usually high--).
    */
    public int findMin5(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Right half is smaller
            if (nums[mid] < nums[high]) {
                high = mid;
            }
            // Left half is smaller
            else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            // Duplicate case → shrink only one side
            else {
                high--;
            }
        }

        return nums[low];
    }

}
