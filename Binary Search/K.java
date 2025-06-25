//Find Nth root of an integer

public class K {
    
// Approach-1: Linear Search
// TC = O(M.LogN), SC = O(1)
/*
 1. 1 < ans(x) < m ; x^n = m
 */
public static long func1(int b, int exp){
    long ans = 1;
    long base = b;
    while(exp > 0) {
        if(exp%2 == 1) {
            exp--;
            ans *= base;
        }
        else{
            exp /= 2;
            base = base*base;
        }
    }
    return ans;
}
public static int NthRoot1(int n, int m){
    //linear search on answer space
    for(int i = 1; i<=m; i++){
        long val = func1(i,n);
        if(val == (long)m) return i;
        else if(val > (long)m) break;
    }
    return -1;
  }


// Approach-2: Binary Search on answer space
// TC = O(LogN.LogM), SC = O(1)
public static int func2(int mid, int n, int m) {
    long ans = 1;
    long base = mid;
    while (n > 0) {
        if ((n & 1) == 1) {  // If n is odd
            ans *= base;
            if (ans > m) return 2; // Overflow case
        }
        base *= base;
        if (base > m) return 2; // base^2 already too large
        n >>= 1; //efficeint way to divide n by 2
    }
    if (ans == m) return 1;
    return 0;
}

public static int NthRoot2(int n, int m) {
    int low = 1, high = m;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        int midN = func2(mid, n, m);
        if (midN == 1) return mid;
        else if (midN == 0) low = mid + 1;
        else high = mid - 1;
    }
    return -1;
}


}
