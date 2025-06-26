// Interfaces: extends keyword
public class OOPS_V2 {
    //The extends keyword is used in two main cases:
    //1. Class Inheriting Another Class (Single Inheritance)
    class Animal {
    void makeSound() {
        System.out.println("Some sound");
    }
}

    class Dog extends Animal {
    void bark() {
        System.out.println("Woof!");
    }
}

  //2. Interface Inheriting Another Interface (Multiple Inheritance)
  //Also Interfaces can extend multiple interfaces:
  interface A {
    void methodA();
}

interface B {
    void methodB();
}

interface C extends A, B {
    void methodC();
}

//What extends CANNOT do:
//1. A class cannot extend multiple classes:
class A {}
class B {}
class C extends A, B {} // ❌ Not allowed!


//2. A class cannot extend an interface:
interface A {}
class B extends A {} // ❌ Error: class cannot extend interface

//3. For a class to inherit an interface, you use implements, not extends.
}
