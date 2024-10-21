public class OOPS_U1 {
    public static void main(String args[]) {
    Horse h = new Horse();
    h.eat();
    h.walk();
    System.out.println(h.color);
   
    
}

}

abstract class Animal {
    String color;
    Animal() {  //Constructor
        color = "brown";
    }
    //non-abstract method
    void eat() {    
    System.out.println("animal eats");  //implemtation
  
   }
   //abstract method
   abstract void walk(); 
}
  //subclasses 
class Horse extends Animal{
    void changeColor() {
        color = "dark brown";
    }
    void walk() {   //implementing walk
        System.out.println("walks on 4 legs"); //implementation of abstarct method
    }
}

class Chicken extends Animal {
    void changeColor() {
            color = "Yellow";
        }
    void walk() {
        
        System.out.println("walks on 2 legs");
    }
}

/* we get by deflut brown because */