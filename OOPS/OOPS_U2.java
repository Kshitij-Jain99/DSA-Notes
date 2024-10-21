public class OOPS_U2 {
    public static void main(String args[]) {
   Mustang myHorse = new Mustang();
   //Animal  -> Horse -> Mustang
    
   }

}

abstract class Animal {
    String color;

    Animal() {
        System.out.println("animal constructor is called");
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
    Horse(){
        System.out.println("Horse constructor called");

    }
    void changeColor() {
        color = "dark brown";
    }
    void walk() {   //implementing walk
        System.out.println("walks on 4 legs"); //implementation of abstarct method
    }
}

class Mustang extends Horse{
    Mustang() {
        System.out.println("Mustang constructor called");
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

