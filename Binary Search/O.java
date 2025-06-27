//Capacity to Ship Packages within D Days

public class O {

//Approach-1: Brute Force
// TC = O(N * (sum(weights[]) - max(weight[]) + 1)), SC = O(1)
public static int findDays1(int[] weights, int cap){
    int days = 1; //first day
    int load = 0;
    int n = weights.length;
    for(int i =0; i<n; i++){
        if(load + weights[i] > cap){
            days += 1; //move to next day
            load = weights[i]; //load next day
        } else{
            load += weights[i]; //load on same day
        }
    }
    return days;
}
public static int leastWeightCapacity1(int[] weights, int d){
    //find max. elemnt and array summation
    int maxi = Integer.MIN_VALUE, sum = 0;
    for(int i = 0; i<weights.length; i++ ){
        sum += weights[i];
        maxi = Math.max(maxi, weights[i]);
    }
    for(int i = maxi; i<= sum; i++)  if(findDays1(weights, i) <= d) return i;
    return -1;
}

//Approach-2: BS on answer space
// TC = O(N * log(sum(weights[]) - max(weight[])+ 1)), SC = O(1)
public static int findDays2(int[] weights, int cap) {
        int days = 1; //First day.
        int load = 0;
        int n = weights.length; //size of array.
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1; //move to next day
                load = weights[i]; //load the weight.
            } else {
                //load the weight on the same day.
                load += weights[i];
            }
        }
        return days;
    }

    public static int leastWeightCapacity2(int[] weights, int d) {
        //Find the maximum and the summation:
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < weights.length; i++) {
            high += weights[i];
            low = Math.max(low, weights[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays2(weights, mid);
            if (numberOfDays <= d) {
                //eliminate right half
                high = mid - 1;
            } else {
                //eliminate left half
                low = mid + 1;
            }
        }
        return low;
    }
}
