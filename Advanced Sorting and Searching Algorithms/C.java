//Bucket Sort: Q1
// TC = O(N^2){worst case}, O(n+k){average case}; SC = O(N)
import java.util.*;

public class C {
    static void BucketSort(float[] arr){
        int n = arr.length;
        //Buckets
        ArrayList<Float>[] buckets = new ArrayList[n]; //ArrayList type of Array

        //create empty buckets
        for(int i =0; i<n; i++) buckets[i] = new ArrayList<Float>();

        //add elements into our buckets
        for(int i =0; i<n; i++) {
            int bucketIndex = (int) arr[i]*n;
            buckets[bucketIndex].add(arr[i]);
        }

        //sort each bucket individually
        for(int i =0; i<buckets.length; i++){
            Collections.sort(buckets[i]);
        }

        //merge all buckets to get final sorted array
        int index = 0;
        for(int i = 0; i<buckets.length; i++){
            ArrayList<Float> currBucket = buckets[i];
            for(int j = 0; j<currBucket.size(); j++){
                arr[index++] = currBucket.get(j);
            }
        }
    }
}
