public class OOPS_J {
    //Single level inheritance
    public static void main(String args[]) {
        Fish shark = new Fish();
         shark.eat();         //this function is present is animal class but not in fish class, but due to "extends" use this will be usable for fish classs 
    }
}
 //Base class
class Animal{
    String color; //property
    //functions
    void eat() {
        System.out.println("eats");

    }
    void  breathe() {
        System.out.println("breathe");
    }
}

//Derived class
class Fish extends Animal { 
   //property
   int fins;
   
//function
void swim() {
    System.out.println("swims in water");
    }

}