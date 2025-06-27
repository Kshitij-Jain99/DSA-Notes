//Find the Smallest Divisor Given a Threshold

public class N {

//Approach-1: Brute Force
// TC = O(max(arr[]) * N), SC = O(1)
public static int smallestDivisor1(int[] arr, int limit){
    int n = arr.length;
    
    int maxi = Integer.MIN_VALUE;        //Find the max. value
    for(int i = 0; i<n; i++) maxi = Math.max(arr[i], maxi);

    for(int d = 1; d<= maxi; d++){   //Find summation result
        int sum = 0;
        for(int i = 0; i<n; i++) sum += Math.ceil((double)arr[i]/ (double)(d));
        if(sum <= limit) return d;
    }
    return -1;
 }

//Approach-2: BS on answer space
// TC = O(log(max(arr[])) * N), SC = O(1)
public static int sumByD(int[] arr, int div){
    int n = arr.length;
    int sum = 0;
    for(int i = 0; i<n; i++) sum += Math.ceil((double)(arr[i]) / (double)(div));
    return sum;
}
public static int smallestDivisor2(int[] arr, int limit){
    int n = arr.length;
    if(n > limit) return -1;

    int maxi = Integer.MIN_VALUE;
    for(int i =0; i<n; i++) maxi = Math.max(maxi, arr[i]);

    int low = 1, high = maxi;
    while(low <= high){
        int mid = (low + high)/2;
        if(sumByD(arr, mid) <= limit) high = mid - 1;
        else low = mid + 1;
    }
    return low;
 }
}
