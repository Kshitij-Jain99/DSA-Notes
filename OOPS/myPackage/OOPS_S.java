package myPackage;

import java.util.*; //if we do not import this pacakage then we see error in Scanner sc, kyoki scanner name ki class  mil hi hi rhi hai kyoki vo util ke pacakge mein hai

public class OOPS_S {
    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in); //Scanner constructor ke aandar System.in name ka parameter pass hota hai
    int a = sc.nextInt();
    System.out.println(a);
   }
}
