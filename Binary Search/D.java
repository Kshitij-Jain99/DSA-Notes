//Search Element in a Rotated Sorted Array
import java.util.ArrayList;
/*
  Rotation in array::
  arr[] = [1 2 3 4 5] -> Rotate at idx = 3{arr[3] = 4}
  rotArr[] = [4 5 1 2 3]
 */
public class D {

    //Approach-1: Brute Force
    // TC = O(N), SC = O(1)
public static int search1(ArrayList<Integer> arr, int n, int k){
   for(int i = 0; i<n; i++) {
     if(arr.get(i) == k) return i;
   }
   return -1;
  }


  // Approach-2: Binary Search
  // TC = O(logN), SC = O(1)
/*
 1. BS even when whole arr is not sorted, but only left and right halfs are sorted.
 2. The rotation creates a challenge in elimination process.
 3. First, we identify the sorted half of the array. 
 4. Once found, we determine if the target is located within this sorted half. 
     If not, we eliminate that half from further consideration. 
     Conversely, if the target does exist in the sorted half, we eliminate the other half.
 5. If arr[low] <= arr[mid]: This condition ensures that the left part is sorted. Now look for target.
 6. Otherwise, if the right half is sorted, now look for target.
 */
public static int search2(ArrayList<Integer> arr, int n, int k){
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = (low + high)/2;
        
        if(arr.get(mid) == k) return mid;  //if mid points to target
        
        if(arr.get(low) <= arr.get(mid)){ //left part is sorted
            if(arr.get(low) <= k && k < arr.get(mid)) high = mid-1; //target in left half
            else low = mid + 1; //target in right half
        } else{       //right part is sorted
            if(arr.get(mid) <= k && k <= arr.get(mid)) low = mid+1;  //target in right half
            else high = mid - 1; //target in left half
        }    
    }
    return -1;
  }
}
