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
