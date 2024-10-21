public class OOPS_H {
//not passing value in constructor, no initialization 
     public static void main(String args[]) {
     Student s1 = new Student(); 
     s1.name = "shradha";
     s1.password = "abcd";
     s1.roll = 456;
     s1.marks[0] = 100;
     s1.marks[1] = 99;
     s1.marks[2] = 80;

     Student s2 = new Student(s1);   //copy constructor called
     s2.password = "xyz"; //giving new password to s2
     s1.marks[2] = 100;  //updating values for s1
    for(int i=0; i<3; i++) {
        System.out.println(s2.marks[i] );
       }
    }
 }
 
 class Student{ 
 String name;
 int roll;
 String password;
 int marks[];
 Address add;
 class Address{   //subclass, shows changes if we change its value.
    String city;
 }
 //shallow copy constructor
//  Student(Student s1) {   
//     this.name = s1.name;   //leaving password
//     this.roll = s1.roll;
//     this.marks=s1.marks;
//  }
 
 //deep copy constructor-ek ek karke marks ki value copy ho rhi hai
 Student(Student s1) {
    marks = new int[3];
    this.name = s1.name;
    this.roll = s1.roll;
    for(int i=0; i<marks.length; i++){
        this.marks[i] = s1.marks[i];
    }
 }
 Student(){           // Nono-parameterised constructor
    marks = new int[3];
    System.out.println("constructor is called...");            
     }
 Student(String name) {  //Parameterized constructor
    marks = new int[3];
    this.name = name;
 }
Student(int roll) {
    marks = new int[3];
    this.roll = roll;
}
}

 
