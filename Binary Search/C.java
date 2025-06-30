//First and Last Occurance in Array

public class C {
    //Appraoch-1: Brute Force
    // TC = O(N), SC = O(1)
public static int[] solve1(int n, int key, int[] v){
    int firstOcc = -1, lastOcc= -1;
    for(int i = n-1; i >= 0; i--){
        if(v[i] == key){
            if(firstOcc == -1) firstOcc = i;
            lastOcc = i;
            break;
        }
    }
    return new int[]{firstOcc, lastOcc};
}


    //Approach-2: Binary Search(lower bound and upper bound)
    // TC = O(logN), SC = O(1)
public static int[] solve2(int n, int key, int[] v) {
    int first = findBound(v, key, true);  // Find first occurrence (lower bound)
    if (first == -1) {
        return new int[]{-1, -1};  // Key not found
    }
    int last = findBound(v, key, false);  // Find last occurrence (upper bound - 1)
    return new int[]{first, last};
}

private static int findBound(int[] v, int key, boolean isFirst) {
    int left = 0;
    int right = v.length - 1;
    int bound = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (v[mid] == key) {
            bound = mid;  // Store the current position
            if (isFirst) {
                right = mid - 1;  // Search left for first occurrence
            } else {
                left = mid + 1;   // Search right for last occurrence
            }
        } else if (v[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return bound;
}

    //Approach-3: Binary Search(divided in two loops)
    // TC = O(logN), SC = O(1)
public static int[] solve3(int n, int key, int[] v) {
    int[] result = new int[]{-1, -1};
    int left = 0;
    int right = n - 1;
    
    // Find first occurrence (lower bound)
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (v[mid] == key) {
            result[0] = mid;
            right = mid - 1; // Search left for earlier(smaller idx) occurrence
        } else if (v[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    // Early exit if key not found
    if (result[0] == -1) {
        return result;
    }
    
    // Reset pointers for last occurrence
    left = 0;
    right = n - 1;
    
    // Find last occurrence (upper bound - 1)
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (v[mid] == key) {
            result[1] = mid;
            left = mid + 1; // Search right for later(last or laregst idx) occurrence
        } else if (v[mid] < key) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    
    return result;
}
}
