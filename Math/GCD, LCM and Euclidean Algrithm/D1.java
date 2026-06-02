// EEA:

public class D1 {

    // Approach-1: Recursive:
    // TC: O(log(min(a,b))), SC: O(log(min(a,b)))
    static class Result {        
        // Java functions can return only one object. So we create a class to store all three.
        long gcd, x, y;

        Result(long gcd, long x, long y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    static Result extendedGCD1(long a, long b) {
        if (b == 0)  return new Result(a, 1, 0);
        Result r = extendedGCD1(b, a % b);

        return new Result(
                r.gcd,
                r.y,
                r.x - (a / b) * r.y
        );
    }


    // Approach-2: Iterative
    // TC: O(log(min(a,b))), SC: O(1)
    static long extendedGCD2(long a, long b) {
        long x0 = 1, y0 = 0;   // coefficients for current a
        long x1 = 0, y1 = 1;   // coefficients for current b

        while (b != 0) {
            long q = a / b;   // quotient

            long temp = a % b;
            a = b;
            b = temp;

            temp = x0 - q * x1;
            x0 = x1;
            x1 = temp;

            temp = y0 - q * y1;
            y0 = y1;
            y1 = temp;
        }

        return a;
    }
}