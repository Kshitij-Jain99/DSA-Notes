
class A{
    public A()
    {System.out.println("A 1");}
}

class B extends A{
  public B()
  this();    //this must be the first step-property
  {System.out.println("B 1");}
}

public B(int k){
    //automatically written by compiler---super();
    {System.out.println("B 2");}
}

public class OOPS_Y{
    public static void main(String[] args)
    {
        B o1 =new B();
    }
}