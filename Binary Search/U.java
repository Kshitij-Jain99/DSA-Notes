//Median of two Sorted Arrays of Different Sizes
import java.util.*;
public class U {
    
    //Approach-1: Brute Force(Two Pointers)
    // TC = O(N1 + N2), SC = O(N1 + N2)
public static double median1(int[] a, int[] b){
    int n1 = a.length;
    int n2 = b.length;

    List<Integer> arr3 = new ArrayList<>();
    int i = 0, j = 0;
    while(i < n1 && j < n2){
        if(a[i] < b[j]) arr3.add(a[i++]);
        else arr3.add(b[j++]);
    }
    
    while(i < n1) arr3.add(a[i++]);
    while(j < n2) arr3.add(b[j++]);

    int n = n1 + n2;
    if(n % 2 == 1) return (double) arr3.get(n/2); //odd n

    double median = ((double) arr3.get(n/2) + (double) arr3.get((n/2) - 1)) / 2.0;
    return median;
  } 

    //Approach-2: Better
    // TC = O(N1 + N2), SC = O(1)
public static double median2(int[] a, int[] b){
    int n1 = a.length;
    int n2 = b.length;
    int n = n1+n2;

    int idx2 = n/2;
    int idx1 = idx2 - 1;

    int cnt = 0;
    int idx1El =-1, idx2El =-1;

    int i = 0, j = 0;
    while( i < n1 && j < n2){
        if(a[i] < b[j]){
            if(cnt == idx1) idx1El = a[i];
            if(cnt == idx2) idx2El = a[i];
            cnt++;
            i++;
        } else{
            if(cnt == idx1) idx1El = b[j];
            if(cnt == idx2) idx2El = b[j];
            cnt++;
            j++;
        }
    }
    //left out elements
    while(i < n1){
        if(cnt == idx1) idx1El = a[i];
        if(cnt == idx2) idx2El = a[i];
        cnt++;
        i++;
    }
    while(j < n2){
        if(cnt == idx1) idx1El = b[j];
        if(cnt == idx2) idx2El = b[j];
        cnt++;
        j++;
    }

    if(n%2 == 1) return (double) idx2El;
    return (double)((double)(idx1El + idx2El))/2.0;
}

    //Approach-3: Binary Search
    // TC = O(), SC = O(1)

}
