//Static Getters/Setters: Avoid using
/*
 1. Java allows static getters/setters, but they behave differently from instance methods.
 2. It’s Usually a Bad Idea: It Violates Encapsulation.
      Static fields belong to the class, not instances.
      Changes affect all objects, breaking data isolation.
 3. Defeats the Purpose of OOP
      Getters/setters are meant to control instance-specific state.
      Static methods ignore instance state, making them behave like global variables.
 4. Thread Safety Issues:
      Static fields are shared across threads → Risk of race conditions.
      Requires synchronization (e.g., synchronized), complicating code.
 5. When Might Static Getters/Setters Make Sense:
      Singleton Pattern
      Constants (Final Static Fields)
      Utility Classes (e.g., Math)
 */

public class OOPS_C2 {
    public class Person {
    private static int age;  // static field

    // Static getter/setter
    public static int getAge() { return age; }
    public static void setAge(int a) { age = a; }
}

 /*main method call:
     Person p1 = new Person();
     Person p2 = new Person();
     Person.setAge(30);  // Changes age for p1, p2, and future instances! */

//Singleton patterns
 public class Singleton {
    private static Singleton instance;
    
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}

// Constants (Final Static Fields)
public class Constants {
    private static final String API_KEY = "12345";
    
    public static String getApiKey() { return API_KEY; }
}

// Utility Classes (e.g., Math)
public class MathUtils {
    private static double PI = 3.14159;
    public static double getPi() { return PI; }
}
    }
