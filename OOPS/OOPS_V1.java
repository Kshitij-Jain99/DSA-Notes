// Java doesn't support multiple inheritance with classes but does allow a class to implement multiple interfaces.

public class OOPS_V1 {
    public static void main(String args[]) {
        Bear bear = new Bear();
        bear.eatPlants();
        bear.eatMeat();
    }
}

interface Herbivore {
    void eatPlants();  // Define methods related to herbivores
}

interface Carnivore {
    void eatMeat();  // Define methods related to carnivores
}

//a class can inherit multiple interfaces using the implements keyword
class Bear implements Herbivore, Carnivore {
    @Override
    public void eatPlants() {
        System.out.println("Bear eats plants");
    }

    @Override
    public void eatMeat() {
        System.out.println("Bear eats meat");
    }
}
