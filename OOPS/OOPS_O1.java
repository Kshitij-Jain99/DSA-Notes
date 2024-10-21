interface Animal {
    void eat();
}

interface Mammal extends Animal {
    void walk();
}

interface Bird extends Animal {
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

public class OOPS_O1 {
    public static void main(String[] args) {
        Bat bat = new Bat();
        bat.eat();
        bat.walk();
        bat.fly();
    }
}
/*In this code, Animal is an interface, Mammal and Bird are interfaces that extend Animal, and Bat is a class that implements both Mammal and Bird.
 This forms a diamond-like structure in the inheritance hierarchy, with Animal at the top, Mammal and Bird in the middle, and Bat at the bottom. */