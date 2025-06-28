
import java.util.Arrays;

//Aggressive Cows

public class Q {

    //Approach-1: Brute Force
    // TC: O(NLogN{Sorting} + N*(max(stalls[]) - min(stalls[]))), SC: O(1)
public static boolean canWePlace1(int[] stalls, int dist, int cows){
    int n = stalls.length;
    int cntCows = 1;  //no. of cows placed, first cow placed at stalls[0]
    int last = stalls[0]; //pos. of last placed cow
    for(int i = 1; i<n; i++){
        if(stalls[i] - last >= dist){
            cntCows++;
            last = stalls[i];
        }
        if(cntCows >= cows) return true;
    }
    return false;
}
public static int aggressiveCows1(int[] stalls, int k){
    int n = stalls.length;
    Arrays.sort(stalls);

    int limit = stalls[n-1] - stalls[0];
    for(int i = 1; i<= limit; i++){ //mim. distace between cows
        if(canWePlace1(stalls, i, k) == false) return (i-1);
    }
    return limit;
}
    
    //Approach-2: BS on answer space: min(max) or max(min)
    //TC = O(N.LogN + N * log(max(stalls[]) - min(stalls[]))), SC = O(1)
public static boolean canWePlace2(int[] stalls, int dist, int cows){
    int n = stalls.length;
    int cntCows = 1; 
    int last = stalls[0];
    for(int i = 1; i<n; i++){
        if(stalls[i] - last >= dist){
            cntCows++;
            last = stalls[i];
        }
        if(cntCows >= cows) return true;
    }
    return false;
  }
public static int aggressiveCows2(int[] stalls, int k){
    int n = stalls.length;
    Arrays.sort(stalls);

    int low = 1, high = stalls[n-1] - stalls[0];
    while(low <= high){
        int mid = (low + high)/2;
        if(canWePlace2(stalls, mid, k) == true) low = mid +1;
        else high = mid-1;
    }    
    return high;
  }
}
