public class Recursion_M {
    public static int tilingProblem(int n){ //2xn is floor size
  //base case
  if(n==0|| n==1) {
    return 1;  
}
    //kaam-choice
    //vertical choice
    int fnm1 = tilingProblem(n-1);

    //horizonatl choice
    int fnm2 = tilingProblem(n-2);
    int totWays = fnm1 + fnm2;
    return totWays;

    }
    public static void main(String args[]){
     System.out.println(tilingProblem(4));
    }
}
