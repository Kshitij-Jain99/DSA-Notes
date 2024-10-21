public class OOPS_R {
/*non-static variable this cannot be referenced from a static context
        Deer d = new Deer(); */
    public static void main(String[] args) {
        Deer d = new Deer();
        d.eat();
    }

    class Animal {
        void eat() {
            System.out.println("Animal eats...");
        }
    }

     class Deer extends Animal {
        @Override
        void eat() {
            System.out.println("Deer eats grass...");
        }
    }
}
