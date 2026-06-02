// Binary GCD (Stein's Algorithm):

public class C {

    // Approach-1: Recursive
    // TC = O(log(max(a,b))),  SC = O(Logn)
    static boolean even(long x) {
        return (x & 1) == 0;
    }

    static long gcd(long a, long b) {

        if (a == 0) return b;
        if (b == 0) return a;

        if (even(a) && even(b))
            return gcd(a >> 1, b >> 1) << 1;

        if (even(a)) return gcd(a >> 1, b);

        if (even(b)) return gcd(a, b >> 1);

        if (a >= b)
            return gcd((a - b) >> 1, b);

        return gcd((b - a) >> 1, a);
    }


    // Approach-2: Iterative 
    // TC = O(Log(max(a,b))), SC = O(1)
    static long gcd2(long a, long b) {

        if (a == 0) return b;
        if (b == 0) return a;

        int k = 0;

        while (((a | b) & 1) == 0) {
            a >>= 1;
            b >>= 1;
            k++;
        }

        while ((a & 1) == 0) a >>= 1;

        while (b != 0) {
            while ((b & 1) == 0) b >>= 1;

            if (a > b) {
                long t = a;
                a = b;
                b = t;
            }

            b -= a;
        }

        return a << k;
    }
}