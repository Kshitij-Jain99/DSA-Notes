interface Animal {
    void eat();
    void breathe();
}

interface Mammal {
    void walk();
}

interface Bird {
    void fly();
}

class Bat implements Animal, Mammal, Bird {
    public void eat() {
        System.out.println("Bat eats");
    }

    public void breathe() {
        System.out.println("Bat breathes");
    }

    public void walk() {
        System.out.println("Bat walks");
    }

    public void fly() {
        System.out.println("Bat flies");
    }
}

public class OOPS_O {
    public static void main(String[] args) {
        Bat bat = new Bat();
        bat.eat();
        bat.breathe();
        bat.walk();
        bat.fly();
    }
}
/*In this code, Animal, Mammal, and Bird are interfaces. The Bat class implements all three interfaces, meaning it must provide implementations for
 all the methods declared in those interfaces. This is how Java achieves multiple inheritance-like behavior. */