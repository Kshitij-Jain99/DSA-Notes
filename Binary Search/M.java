//Minimum days to make M bouquets

public class M {

    //Approach-1: Brute Force
    // TC = O((max(arr[]) - min(arr[]) + 1)*N), SC = O(1)
    /*
     1. We are running a loop to check our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer, we will call the possible() function.
     */
public static boolean possible1(int[] arr, int day, int m, int k){
    int n = arr.length;
    int cnt = 0;
    int noOfB = 0;
    
    for(int i = 0; i<n; i++){ //counting number of bouquets
        if(arr[i] <= day) cnt++; //arr[i] has already bloomed
        else {                   //arr[i] has not bloomed yet
            noOfB += cnt/k;
            cnt = 0;
        }
    }
    noOfB += cnt/k;
    return noOfB >= m;
}
public static int roseGarden1(int[] arr, int k, int m){
    int n = arr.length;
    if((long)m*k > n) return -1; //impossible case
    int mini = Integer.MIN_VALUE, maxi = Integer.MAX_VALUE;
    for(int i =0; i<n; i++){  //find max and min
        mini = Math.min(mini, arr[i]);
        maxi = Math.max(maxi, arr[i]);
    }
    for(int i = mini; i<= maxi; i++){ //working on answer space
        if(possible1(arr, i, m, k)) return i;
    }
    return -1;
}


    //Approach-2: BS on answer space
    // TC = O((log((max(arr[]) - min(arr[])+ 1) * N), SC = O(1)
public static boolean possible2(int[] arr, int day, int m, int k){
    int n = arr.length;
    int cnt = 0;
    int noOfB = 0;

    for(int i = 0; i<n; i++){ //count number of bouquets
        if(arr[i] <= day) cnt++;
        else{
            noOfB += cnt/k;
            cnt = 0;
        }
    }
    noOfB += cnt/k;
    return noOfB >= m;
}
public static int roseGarden2(int[] arr, int k, int m){
    int n = arr.length;
    if((long) m*k > n) return -1; //impossibel case

    int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
    for(int i =0; i<n; i++){
        mini = Math.min(mini, arr[i]);
        maxi = Math.max(maxi, arr[i]);
    }
    int low = mini, high = maxi;
    while(low <= high){
        int mid = (low + high)/2;
        if(possible2(arr, mid, m, k)) high = mid -1;
        else low = mid + 1;
    }
    return low;
}

}
