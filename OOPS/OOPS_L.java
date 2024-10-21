public class OOPS_L {
    //Multi level inheritance
    public static void main(String args[]) {
        Dog dobby =new Dog();
        dobby.eat();
        dobby.legs = 4;
        System.out.println(dobby.legs);
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


class Mammals extends Animal{
    int legs;
}
class Dog extends Mammals{
    String breed;
}