//Find Nth root of an integer (B.S. on Answer Space)

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
            if(exp % 2 == 1) {
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
        for(int i = 1; i <= m; i++){
            long val = func1(i,n);

            if(val == (long) m) return i;
            else if(val > (long) m) break;
        }
        return -1;
    }


    // Approach-2: Binary Search on answer space
    // TC = O(LogN.LogM), SC = O(1)
    public static int func2(int mid, int n, int m) {
        long ans = 1;
        long base = mid;
        while (n > 0) {
            if ((n & 1) == 1) {             // If n is odd
                ans *= base;
                if (ans > m) return 2;      // Overflow case
            }
            base *= base;
            if (base > m) return 2;         // base^2 already too large
            n >>= 1; 
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


    // Approach-3: Newton’s Method (Advanced / Fastest Convergence)
    // TC ≈ O(k * logN), SC = O(1)
    /*
    Formula:
    X(k+1 or next) = 1/n * ((n - 1) * x(k or curr) + m / (x(k or curr) ^ (n-1))) 

    1. Start with initial guess x = m
    2. Iterate to refine root
    3. Round result and verify
    4. Very fast covergence due to Fewer iterations than binary search (k= iterations, usually small ~20–30)
    5. Use it when: Floating-point precision issues
    */
    public static int NthRoot3(int n, int m) {

        // Edge cases
        if (m == 0) return 0;
        if (n == 1) return m;

        double x = m; // initial guess

        // Iterate (fixed iterations for convergence)
        for (int i = 0; i < 25; i++) {
            x = ((n - 1) * x + m / Math.pow(x, n - 1)) / n;
        }

        int ans = (int)Math.round(x);

        // Verify exact root (important!)
        long check = 1;
        for (int i = 0; i < n; i++) {
            check *= ans;
            if (check > m) return -1;
        }

        if (check == m) return ans;
        return -1;
        }   


    // Approach-4: Logarithmic Method (Using Math.pow): Quick Computation
    // TC = O(LogN), SC = O(1)
    /*
        Idea:
        x = m^(1/n)
    1. Compute root using logarithm / power
    2. Round to nearest integer (Floating-point precision issues)
    3. Verify by raising back to power n
    4. Good when constraints are small and approx. ans are okay, might fail for larger inputs
    */
    public static int NthRoot4(int n, int m) {
        if (m == 0) return 0;
        if (n == 1) return m;

        double root = Math.pow(m, 1.0 / n);
        int ans = (int)Math.round(root);

        // Verify exact root (important due to precision errors)
        long check = 1;
        for (int i = 0; i < n; i++) {
            check *= ans;
            if (check > m) return -1;
        }

        if (check == m) return ans;
        return -1;
    }
}
