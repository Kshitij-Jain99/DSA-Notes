// Find out how many times arr has been rotated (B.S. on 1D Arrays)

public class G {
    
    // Approach-1: Brute Force
    // TC = O(N), SC = O(1)
    public int findRotations1(int[] arr) {
        int n = arr.length;
        int minVal = arr[0];
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndex = i;
            }
        }
        // The index of smallest element = number of rotations
        return minIndex;
    }


    // Approach-2: Better
    // TC = O(N), SC = O(1)
    public int findRotationCount2(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // If break in ascending order found
            if (arr[i] > arr[i + 1]) {
                // Index of next element is rotation count
                return i + 1;
            }
        }
        // No rotation found
        return 0;
    }


    // Approach-3: Binary Search
    // TC = O(LogN), SC = O(1)
    public int findRotations3(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than element at high,
            // smallest element lies to the right of mid
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Else smallest element is at mid or to the left
                high = mid;
            }
        }

        // When low == high, we found the smallest element
        return low;
    }


    // Approach-4: Variant(Binary Search with Duplicates)
    // TC = O(log N) avg, O(N) worst, SC = O(1)
    public int findRotationsWithDuplicates(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                // Minimum lies in right half
                low = mid + 1;
            } 
            else if (arr[mid] < arr[high]) {
                // Minimum lies in left half (including mid)
                high = mid;
            } 
            else {
                // arr[mid] == arr[high]
                // Can't decide → reduce search space safely
                high--;
            }
        }
        return low; // index of minimum = rotation count
    }
}
