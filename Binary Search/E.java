//Search Element in a Rotated Sorted Array-II
import java.util.ArrayList;

public class E {

    //Approach-1: Brute Force
    // TC = O(N), SC = O(1)
public static int search1(int[] arr, int n, int k){
   for(int i = 0; i<n; i++) {
     if(arr[i] == k) return i;
   }
   return -1;
  }


  // Approach-2: Binary Search
  // TC = O(logN), SC = O(1)
public static int search2(int arr[], int n, int k){
    int low = 0, high = n-1;
    while(low <= high) {
        int mid = (low + high)/2;
        
        if(arr[mid] == k) return mid;  //if mid points to target
        //MODIFICATION: Handle duplicates
        if(arr[low] == arr[mid] && arr[mid] == arr[high]){
            low = low + 1;
            high = high -1;
            continue;
        }
        if(arr[low] <= arr[mid]){ //left part is sorted
            if(arr[low] <= k && k < arr[mid]) high = mid-1; //target in left half
            else low = mid + 1; //target in right half
        } else{       //right part is sorted
            if(arr[mid] <= k && k <= arr[mid]) low = mid+1;  //target in right half
            else high = mid - 1; //target in left half
        }    
    }
    return -1;
  }
}
