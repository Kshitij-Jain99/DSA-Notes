// Diophantine Equation:

class D2 {

    // Approach-1: Recursive
    // Time Complexity: O(log(min(a, b))), Space Complexity: O(log(min(a, b)))
    /*
    1. Use Extended Euclidean Algorithm to find:  ax + by = gcd(a, b)
    2. Let: g = gcd(a, b)
    3. Equation: ax + by = c has solution only if: g divides c
    4. If solution exists, multiply Bézout coefficients by: (c / g)
    */
    static class Triplet {
        long gcd, x, y;
        Triplet(long gcd, long x, long y) {
            this.gcd = gcd;
            this.x = x;
            this.y = y;
        }
    }

    static Triplet extendedGCD1(long a, long b) {
        if (b == 0) return new Triplet(a, 1, 0);

        Triplet small = extendedGCD1(b, a % b);
        long x = small.y;
        long y = small.x - (a / b) * small.y;
        return new Triplet(small.gcd, x, y);
    }

    static void solveEquation1(long a, long b, long c) {
        Triplet ans = extendedGCD1(a, b);
        long g = ans.gcd;

        // No integer solution exists
        if (c % g != 0) {
            System.out.println("No Solution");
            return;
        }

        // Multiply coefficients by (c / gcd)
        long multiply = c / g;
        long x = ans.x * multiply;
        long y = ans.y * multiply;

        System.out.println("One Solution:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }


    // Approach-2: Iterative
    // TC: O(log(min(a, b))), SC: O(1)
    /*
    1. Iteratively apply Euclidean Algorithm while maintaining: x and y coefficients
    2. Final coefficients satisfy: ax + by = gcd(a, b)
    3. Equation: ax + by = c
       has solution only if: gcd(a, b) divides c
    4. Multiply obtained coefficients by: (c / gcd) to get one valid solution
    */
    static Triplet extendedGCD2(long a, long b) {
        long x0 = 1, y0 = 0;
        long x1 = 0, y1 = 1;

        while (b != 0) {
            long q = a / b;

            long temp = a % b;
            a = b;
            b = temp;

            long newX = x0 - q * x1;
            long newY = y0 - q * y1;

            x0 = x1;
            y0 = y1;

            x1 = newX;
            y1 = newY;
        }

        return new Triplet(a, x0, y0);
    }

    static void solveEquation2(long a, long b, long c) {
        Triplet ans = extendedGCD2(a, b);
        long g = ans.gcd;

        // No integer solution exists
        if (c % g != 0) {
            System.out.println("No Solution");
            return;
        }

        // Multiply coefficients by (c / gcd)
        long multiply = c / g;
        long x = ans.x * multiply;
        long y = ans.y * multiply;

        System.out.println("One Solution:");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}