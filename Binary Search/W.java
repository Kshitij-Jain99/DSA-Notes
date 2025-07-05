//Find the row with maximum number of 1's
import java.util.*;

public class W {

    //Appraoch-1: Brute Force
    // TC = O(N*M), SC = O(1)
public static int rowWithMax1s1(ArrayList<ArrayList<Integer>> matrix, int n, int m){
    int cnt_max = 0;
    int index = -1;

    for(int i = 0; i<n; i++){
        int cnt_ones = 0;
        for(int j = 0; j<m; j++){
            cnt_ones += matrix.get(i).get(j);
        }
        if(cnt_ones > cnt_max){
            cnt_max = cnt_ones;
            index = i;
        }
    }
    return index;
  }

    //Approach-2: Binary Search
    // TC = O(N.LogM), SC = O(1)

public static int lowerBound2(ArrayList<Integer> arr, int n, int x){
    int low = 0, high = n-1;
    int ans = n;

    while(low <= high){
        int mid = (low+high)/2;
        if(arr.get(mid) >= x) {
            ans = mid;
            high = mid-1;
        } else{
            low = mid + 1;
        }
    }
    return ans;
 }
public static int rowWithMax1s2(ArrayList<ArrayList<Integer>> matrix, int n, int m){
    int cnt_max = 0;
    int index = -1;

    for(int i =0; i<n; i++){
        int cnt_ones = m - lowerBound2(matrix.get(i), m, 1);
        if(cnt_ones > cnt_max){
            cnt_max = cnt_ones;
            index = i;
        }
    }
    return index;
}
}
