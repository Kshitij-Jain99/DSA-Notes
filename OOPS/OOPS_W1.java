public class OOPS_W1 {
    //Properties ko static banaya
    public static void main(String args[]) {
    Student s1 = new Student();
    s1.schoolName = "JMV";

    Student s2 = new Student();
    System.out.println(s2.schoolName);
    
    Student s3 = new Student();
    s3.schoolName = "ABC";
}
}

class Student {  //static function
     static int returnPercentage(int math, int phy, int chem) {
        return (math+phy+chem)/ 3;
    }
    
    String name;
    int roll;

    static String schoolName; //same for all students

    void setName(String name) {   //geteer-setter
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}
