public class OOPS_E {
    //constructor is initialized
    public static void main(String args[]) {
    Student s1 = new Student("Shradha");  //initializing bygiving name
    System.out.println(s1.name);
    }
}

class Student{ 
String name;
int roll;

Student(String name){           //constructor, no return type
     this.name =name;            
   }
}
