public class OOPS_U {
    public static void main(String args[]) {
    Horse h = new Horse();
    h.eat();
    h.walk();

    Chicken c = new Chicken();
    c.eat();
    c.walk();
   
    /*Animal a =new Animal(); ----this will give error as it is abstarct class and we cannot create its object*/
}

}

abstract class Animal {
    //making abstract/non-abstract methods
    //non-abstract method
    void eat() {    
    System.out.println("animal eats");  //implemtation
  
   }
   //abstract method
   abstract void walk(); 
}
  //subclasses 
class Horse extends Animal{
    void walk() {   //implementing walk
        System.out.println("walks on 4 legs"); //implementation of abstarct method
    }
}

class Chicken extends Animal {
    void walk() {
        System.out.println("walks on 2 legs");
    }
}

//void eat has same imlemenation for horsse and chicken
//void walk has different implemenation for horse and chickemn
/*Abstraction concept is used in the above because walk()
 * implementaion on type of animal but not on th ANIMAL class, 
 * Animal class only gives the idea that all of them will walk
so make a function for each animal  */