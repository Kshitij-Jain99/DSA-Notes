public class G1 {
    // Function to calculate factorial
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Function to calculate grid ways using permutation formula
    public static int gridWays(int n, int m) {
        int totalWays = factorial(n - 1 + m - 1) / (factorial(n - 1) * factorial(m - 1));
        return totalWays;
    }

    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(gridWays(n, m));
    }
}
