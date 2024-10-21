interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void eat();  // This method conflicts with the eat method in Animal
    void walk();
}

interface Bird extends Animal {
    void eat();  // This method also conflicts with the eat method in Animal
    void fly();
}

class Bat implements Mammal, Bird {
    public void eat() {
        System.out.println("Bat eats");
    }

    public void walk() {
        System.out.println("Bat walks");
    }

    public void fly() {
        System.out.println("Bat flies");
    }
}

public class OOPS_O2 {
    public static void main(String[] args) {
        Bat bat = new Bat();
        bat.eat();  // Which eat method should this call?
        bat.walk();
        bat.fly();
    }
}
/*n this code, both Mammal and Bird interfaces extend Animal and override the eat method. When Bat implements both Mammal and Bird,
there’s a conflict about which eat method to use. This is similar to the Diamond Problem in multiple inheritance. 
However, in Java, this code will still compile and run without errors because interfaces do not provide an implementation for the methods,
so there’s no ambiguity about which method implementation to use. The Bat class provides the implementation for the eat method,
so there’s only one version of the method in the class. */