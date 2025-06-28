//Kth Missing Positive Number


public class P {
//Approach-1: Brute Force
// TC = O(N), SC = O(1)
public static int missingK1(int[] vec, int n, int k){
    for(int i =0; i<n; i++){
        if(vec[i] <= k) k++;
        else break;
    }
    return k;
  }
  
//Approach-2: BS on answer space
// TC = O(LogN), SC = O(1)
public static int missingK2(int[] vec, int n, int k){
    int low = 0, high = n-1;
    while(low <= high){
        int mid = (low + high)/2;
        int missing = vec[mid] - (mid+1);
        if(missing < k) low = mid + 1;
        else high = mid -1;
    }
    return k + high +1;
  }
}
