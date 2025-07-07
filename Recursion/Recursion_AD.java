public class Recursion_AD {
    // Top Down/Pre-order Recursion:
    // printing before recursive call (n->1)

    public static void printDec(int n) {
        if(n==1) {  //creating base function
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);  //calling inner function
    }

    // Bottom-Up Recursion/Post order recursion: 
    // printing after recursion call( 1-> n)

       public static void printInc(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);  // Recursive call first
        System.out.print(n + " ");
    }

    public static void main(String args[]) {
        int n= 10;
        printDec(n);
        printInc(n);
    }
}
