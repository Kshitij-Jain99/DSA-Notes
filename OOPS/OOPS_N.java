//In the provided code, Method() after the name of each sub-derived class (like dogMethod(), catMethod(), etc.) 
//is used to define a unique method for each sub-derived class. These methods are used to demonstrate that 
//each sub-derived class not only inherits methods from its parent class but can also have its own unique methods.
// Base class
class Animal {
    String color; //property

    //functions
    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathe");
    }
}

// Derived classes
class Fish extends Animal {
    void swim() {
        System.out.println("swim");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
}

class Mammal extends Animal {
    int legs;
    void walk() {
        System.out.println("walks");
    }
}

// Sub-derived classes
class Tuna extends Fish {
    void tunaMethod() {
        System.out.println("I am a Tuna fish");
    }
}

class Shark extends Fish {
    void sharkMethod() {
        System.out.println("I am a Shark");
    }
}

class Peacock extends Bird {
    void peacockMethod() {
        System.out.println("I am a Peacock");
    }
}

class Dog extends Mammal {
    void dogMethod() {
        System.out.println("I am a Dog");
    }
}

class Cat extends Mammal {
    void catMethod() {
        System.out.println("I am a Cat");
    }
}

class Human extends Mammal {
    void humanMethod() {
        System.out.println("I am a Human");
    }
}

public class OOPS_N {
    // Hybrid inheritance
    public static void main(String args[]) {
        Dog dobby = new Dog();
        dobby.eat();
        dobby.walk();
        dobby.dogMethod();
        dobby.legs = 4;
        System.out.println(dobby.legs);
    }
}
