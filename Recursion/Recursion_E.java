public class Recursion_E {
    public static int fact(int n) {
        if(n==0){
            return 1;
        }
        int fnm1 = fact(n-1);
        int fn = n*fnm1;
         System.out.println(n + " * " + fnm1 + " = " + fn);
        return fn;
    }
    public static void main (String args[]) {
        int n=5;
       System.out.println(fact(n));
       
    }

}
