// Finding sqrt of a number using Binary Search (B.S. on Answer Space)

public class J {
    
    // Approach-1: Brute Force
    // TC = O(N), SC = O(1)
    public int floorSqrt1(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if ((long)(i) * i <= n) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }
    
    
    // Approach-2: Binary Search
    // TC = O(LogN), SC = O(1)
    public int mySqrt2(int x) {
        // Handle small numbers directly(0,1)
        if (x < 2) return x;

        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid <= x) {
                // Store mid as potential answer
                ans = (int) mid;
                // Move to right half
                left = (int) mid + 1;
            } else {
                // Move to left half
                right = (int) mid - 1;
            }
        }
        return ans;
    }


    // Approach-3: Using Built-in sqrt()
    // TC = O(1), SC = O(1)
    /*
        1. Math.sqrt(x) returns a double, which can have slight precision errors.
        2. Example: Math.sqrt(16) → 4.0 (perfect)
           But sometimes → 3.999999..., which becomes 3 after casting.
        3. So we correct it using small loops. These loops ensure exact floor value.
        4. E.g-1: x = 28 (no precision issue)
           -> int ans = (int) Math.sqrt(28); -> √28 ≈ 5.29 casted to 5
           -> while ((ans + 1)*(ans + 1) <= x) -> (5 + 1)² = 36 > 28 → loop does NOT run
           -> while (ans * ans > x) -> 5² = 25 not > 28 → loop does NOT run
        5. e.g.-2: x = 16 (precision issue case)
           -> ans = (int) Math.sqrt(16);  -> Ideally → 4, But suppose due to precision → 3.999999 → cast → 3
           -> First while loop (fix upward) -> (3 + 1)² = 16 ≤ 16 → ans = 4
           -> Second loop: 4² = 16 not > 16 → skip   
    */
    public int mySqrt3(int x) {
       // Use Math.sqrt and cast to int
       int ans = (int) Math.sqrt(x);

       // Fix possible precision issue
       while ((long)(ans + 1) * (ans + 1) <= x) {
               ans++;
            }
       while ((long)ans * ans > x) {
                ans--;
           }
          return ans;
        }
    

    // Approach-4: Newton-Raphson Method
    // TC ≈ O(log N) (very fast convergence), SC = O(1)
    /*
        1. Newton’s method improves guesses using this formula:
           R(new) = (r + x/r) / 2;
        2. Start with a guess r = x, Keep refining it using the formula, Very quickly approaches √x
        3. Converges much faster than binary search   
        4. Derivation: Newton-Raphson method applied to solving r² = x
           -> r*r = x --> r*r - x = 0 --> f(r) = r*r - x
           -> R(new) = r - f(r)/f'(r)    {Newton-Raphson method}
           -> R(new) = r - (r*r - x)/ 2r 
        5. In Simple words:
           -> You guess a number r, x/r gives another estimate of √x, You average both to get a better guess
           ->  So: new guess = average of (r and x/r)
           -> Each step dramatically improves accuracy, Errors shrink very quickly (faster than binary search)  
    */
    public int mySqrt4(int x) {
        if (x < 2) return x;

        long r = x; // initial guess

        // Iterate until convergence
        while (r * r > x) {
            r = (r + x / r) / 2;
        }

        return (int) r;
    }
}
