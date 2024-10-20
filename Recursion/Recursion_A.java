public class Recursion_A {
    public static void printDec(int n) {
        if(n==1) {  //creating base function
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);  //calling inner function
    }

    public static void main(String args[]) {
        int n= 10;
        printDec(n);
    }
}
