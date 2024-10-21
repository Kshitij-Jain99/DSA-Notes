public class OOPS_R1 {
   /*To resolve the error M1:By making the Animal and Deer classes static, you allow them to be accessed from the static context of the main method. */
    public static void main(String[] args) {
        Deer d = new Deer();
        d.eat();
    }

    static class Animal {
        void eat() {
            System.out.println("Animal eats...");
        }
    }

      static class Deer extends Animal {
        @Override
        void eat() {
            System.out.println("Deer eats grass...");
        }
    }
}
