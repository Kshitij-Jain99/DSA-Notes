public class OOPS_X {
    public static void main(String args[]) {
    Horse h = new Horse();
    System.out.println(h.color);
    }
}

class Animal {
    String color; //PROPERTY
    Animal() {
        System.out.println("animal constructor is called");
    }
}

class Horse extends Animal {
    Horse() {
        super();                 //to call construct0Or of animal class
        super.color = "brown";
        System.out.println("Horse constructor is called");

    }
}