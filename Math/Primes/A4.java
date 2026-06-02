// CF. 1294C: https://codeforces.com/contest/1294/problem/C   

import java.util.*;

public class A4 {

    // Approach-1(156 ms): Greedy
    // TC = O(Sqrt(n)), SC = O(1)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int a = -1, b = -1, c = -1;

            // find first factor
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    a = i;
                    n /= i;
                    break;
                }
            }

            // find second factor
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0 && i != a) {
                    b = i;
                    n /= i;
                    break;
                }
            }
            
            // Remaining is third: c = (n / a.b) 
            c = n;

            if (a != -1 && b != -1 && c != 1 && c != a && c != b) { // all exist, all distinct
                System.out.println("YES");
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println("NO");
            }
        }
    }
}