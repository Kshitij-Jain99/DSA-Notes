//Koko Eating Bananas

public class L {
//Approach-1:Brute Force
// TC = O(max(a[]*N)), SC = O(1)
/*
1. Check all possible answers from 1 to max(a[]). The minimum number for which the required time <= h, is our answer.
*/    
public static int findMax1(int[] v){
    int maxi = Integer.MIN_VALUE;
    //find maximum:
    for(int i = 0; i<v.length; i++) maxi = Math.max(maxi, v[i]);
    return maxi;
}
public static int calculateTotalHours1(int[] v, int hourly){
    int totalH = 0;
    //find total hours:
    for(int i = 0; i<v.length; i++) totalH += Math.ceil((double)v[i]/ (double)(hourly));
    return totalH;
}
public static int minimumRateToEatBananas(int[]v, int h){
    int maxi = findMax1(v);  //find maximum value in array
    
    for(int i = 1; i<= maxi; i++){  //find min. value of h
        int reqTime = calculateTotalHours1(v, i);
        if(reqTime <= h) return i; //found the minimum rate
    }
    return maxi;  //dummy return statement
}

//Approach-2: BS on answer space
// TC = O(N * log(max(a[]))), SC = O(1)
public static int findMax2(int[]v){
     int maxi = Integer.MIN_VALUE;
    //find maximum:
    for(int i = 0; i<v.length; i++) maxi = Math.max(maxi, v[i]);
    return maxi;
}
public static int calculateTotalHours2(int[] v, int hourly){
    int totalH = 0;
    //find total hours:
    for(int i = 0; i<v.length; i++) totalH += Math.ceil((double)v[i]/ (double)(hourly));
    return totalH;
}
public static int minimunRateToEatBananas(int[] v, int h){
    int low = 1, high = findMax2(v);
    while(low <= high){
        int mid = (low + high)/2;
        int totalH = calculateTotalHours2(v, mid);
        if(totalH <= h) high = mid-1;
        else low = mid + 1;
    }
    return low;
}

}
