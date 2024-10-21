public class OOPS_R2 {
    public static void main(String args[]) {
        OOPS_R2 oopsR2Instance = new OOPS_R2();
        Deer2 d = oopsR2Instance.new Deer2();
        d.eat();
    }

    class Animal2 {
        void eat() {
            System.out.println("eats anything");
        }
    }

    class Deer2 extends Animal2 {
        void eat() {
            System.out.println("eats grass");
        }
    }
}
