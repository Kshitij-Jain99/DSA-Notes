public class OOPS_M {
    //Hierarchial inheritance
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
    int legs;void walk() {
        System.out.println("walks");
    }
    }
class Fish extends Animal{
    void swim() {
        System.out.println("swim");
    }
}
class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
}