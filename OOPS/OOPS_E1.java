public class OOPS_E1 {
   //not passing value in constructor, no initialization 
    public static void main(String args[]) {
    Student s1 = new Student();  
    System.out.println(s1.name);
    }
}

class Student{ 
String name;
int roll;

Student(){           //constructor, no return type
    System.out.println("constructor is called...");            
   }
}
