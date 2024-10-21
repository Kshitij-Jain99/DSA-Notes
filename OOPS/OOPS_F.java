public class OOPS_F {
//not passing value in constructor, no initialization 
     public static void main(String args[]) {
     Student s1 = new Student(); 
     Student s2 = new Student("Shradha");
     Student s3 = new Student(123);
     //Student s4 = new Student("aman",567); //now no construtor will be called as we have not made one yet which have these parameters
     System.out.println(s1.name);
     }
 }
 
 class Student{ 
 String name;
 int roll;
 
 Student(){           // Nono-parameterised constructor
 System.out.println("constructor is called...");            
     }
 Student(String name) {  //Parameterized constructor
    this.name = name;
 }
Student(int roll) {
    this.roll = roll;
}
}

 
