public class Recursion_O {
    public static int friendsPairing(int n) {
        if(n==1 || n==2){
            return n;
        }
    //     //choice
    //     //single
    //     int fnm1 = friendsPairing(n-1);

    //     //pair
    //     int fnm2 = friendsPairing(n-2);

    // int pairWays = (n-1)*fnm2;

    // //totways
    // int totWays = fnm1 + pairWays;
    // return totWays;
    return friendsPairing(n-1) + (n-1)*friendsPairing(n-2); //the above all code can be replaced by this single statement
    }
  public static void main(String args[]) {
    System.out.println(friendsPairing(4));
  }
}

