// Single element in Sorted Array (B.S. on 1D Arrays)

public class H {
    
    // Approach-1: Brute Force
    // TC = O(N), SC = O(1)
    public int singleNonDuplicate1(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1])
                    return arr[i];
            } else if (i == n - 1) {
                if (arr[i] != arr[i - 1])
                    return arr[i];
            } else {
                if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                    return arr[i];
            }
        }
        return -1;
    }


    // Approach-2: Bit Manipulation
    // TC = O(N), SC = O(1)
    public int singleNonDuplicate2(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }


    // Approach-3: Binary Search
    // TC = O(LogN), SC = O(1)
    public int singleNonDuplicate3(int[] arr) {
        int n = arr.length;

        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if middle element is the unique one
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }

            // If mid is in the left half (pairing is valid)
            if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) ||
                (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            }
            // If mid is in the right half (pairing broken earlier)
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
