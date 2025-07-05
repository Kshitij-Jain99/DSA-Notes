//K-th Element of two sorted arrays
import java.util.*;

public class V {
    //Approach-1:Brute Force
    // TC = O(M+N), SC = O(M+N)
public static int KthElement1(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k){
    ArrayList<Integer> arr3 = new ArrayList<>();

    //merge
    int i = 0, j = 0;
    while(i < m && j < n){
        if(a.get(i) < b.get(j)) arr3.add(a.get(i++));
        else arr3.add(b.get(j++));
    } 

    //copy the left out elements
    while(i < m) arr3.add(a.get(i++));
    while(j < n) arr3.add(b.get(j++));

    return arr3.get(k-1);

  }
    
    //Approach-2:Space Optimization
    // TC = O(M+N), SC = O(1)
public static int KthElement2(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k){
     int ele = -1;
     int cnt = 0;

     //merge
     int i = 0, j = 0;
     while(i < m && j < n){
        if(a.get(i) < b.get(j)) {
            if(cnt == k-1) ele = a.get(i);
            cnt++; i++;
        } else{
            if(cnt == k-1) ele = b.get(j);
            cnt++; j++;
        }
     }

     //left out elements
     while(i < m) {
        if(cnt == k-1) ele = a.get(i);
        cnt++; i++;
     }
     while(j < n){
        if(cnt == k-1) ele = b.get(j);
        cnt++; j++;
     }

     return ele;
  }

    //Approach-3: Binary Search
    // TC = O(log(min.(m,n))), SC = O(1)
public static int KthElement3(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k){
    if(m > n) return KthElement3(b, a, n, m, k); //swap
    int left = k;   //length of left half

    int low = Math.max(0, k-n), high = Math.min(k, m);
    while(low <= high){
        int mid1 = (low + high) >> 1;   //x
        int mid2 = left - mid1;         //left-x

        //if mid1, mid2 = 0 or n1, n2 , so we store their default values
        int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
        int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

        if(mid1 < m) r1 = a.get(mid1);
        if(mid2 < n) r2 = b.get(mid2);
        if(mid1 - 1 >=0) l1 = a.get(mid1 - 1);
        if(mid2 - 1 >= 0) l2 = b.get(mid2 -1);
        
        if(l1 <= r2 && l2 <= r1) return Math.max(l1, l2);  //answer found
        else if(l1 > r2) high = mid1-1;
        else low = mid1 + 1;

        
    }
     return 0; //dummy return condition to avoid warning or errors
 }

}
