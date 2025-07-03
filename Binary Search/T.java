//Minimise Maximum Distance between Gas Stations
import java.util.*;

public class T {
    
    //Approach-1: Brute Force
    //TC = O(k*N + N), SC = O(N-1)
public static double minimizeMaxDistance1(int[] arr, int k){
    int n = arr.length;
    int[] howMany = new int[n-1];  //track how many gas station out of k are placed in n-1 gaps

    //pick and place k gas stations
    for(int gasStations = 1; gasStations <= k; gasStations++){
        //find max section and insert gas station
        double maxSection = -1;
        int maxIdx = -1;
        for(int i =0; i<n-1; i++){
            double diff = arr[i+1] - arr[i];
            double sectionLength = diff/(double)(howMany[i] + 1);

            if(sectionLength > maxSection){
                maxSection = sectionLength;
                maxIdx = i;
            }
        }
        //insert the current gas station
        howMany[maxIdx]++;
    }
   
    //Find the maximum distance i.e. the answer:
    double maxAns = -1;
    for(int i =0; i<n-1; i++){
        double diff = arr[i+1] - arr[i];
        double sectionLength = diff/ (double)(howMany[i] + 1);
        maxAns = Math.max(maxAns, sectionLength);
    }
    return maxAns;
  }    


  //Approach-2: Using Priority Queue
  // TC = O(N.LogN + K.LogN), SC = O(2*(n-1))
public static class Pair{
    double first;
    int second;

    Pair(double first, int second){
        this.first = first;
        this.second = second;
    }
}

public static double minimizeMaxDistance2(int[] arr, int k){
    int n = arr.length;
    int[] howMany = new int[n-1];
    PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));

    //insert first n-1 elements in PQ, with respective distance values: NLogN
    for(int i =0; i<n-1; i++) pq.add(new Pair(arr[i+1] - arr[i], i));

    //pick and place k gas stations: K.LogN
    for(int gasStations = 1; gasStations <=k; gasStations++){
         //find max section and insert gas station
         Pair tp = pq.poll();
         int secIdx = tp.second;

         //insert the current gas station
         howMany[secIdx]++;

         double inidiff = arr[secIdx + 1] - arr[secIdx];
         double newSecLen = inidiff / (double)(howMany[secIdx] + 1);
         pq.add(new Pair(newSecLen, secIdx));
    }
    return pq.peek().first;
  }

  //Appraoch-3: Binary Search
  // TC = O(N*Log(len. of answer space) + N), SC = O(1)
public static int numberOfGasStationsRequired3(double dist, int[] arr){
    int n = arr.length;
    int cnt = 0;
    for(int i =1; i<n; i++){
        int numberInBetween = (int)((arr[i] - arr[i-1])/ dist);
        if((arr[i] - arr[i-1]) == (dist*numberInBetween)){   //edge case
            numberInBetween--;
        }
        cnt += numberInBetween;
    }
    return cnt;
 }

 public static double minimizeMaxDistance(int[] arr, int k){
    int n = arr.length;
    double low = 0;
    double high = 0;

    //Find max. distance:
    for(int i =0; i<n-1; i++){
        high = Math.max(high, (double)(arr[i+1] - arr[i]));
    }
    //Apply Binary search:
    double diff = 1e-6;
    while(high-low > diff){
        double mid = (low + high)/ (2.0);
        int cnt = numberOfGasStationsRequired3(mid, arr);
        if(cnt > k) low = mid;
        else high = mid;
    }
    return high;
 }
}
