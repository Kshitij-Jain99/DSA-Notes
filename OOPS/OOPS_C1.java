//Instance Getters/Setters: Always use

public class OOPS_C1 {
        public static void main(String args[]) {
        Pen p1 = new Pen();  //creating a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        //p1.setColor("Yellow");
        p1.setColor ("Yellow");
        System.out.println(p1.getColor());
    }
}

class Pen {//setters were already made before, so make getters now
    //Instance variables should be private to restrict direct access from outside the class.
    private String color;
    private int tip; //1. pen ki property wala variable tip hai

    String getColor(){
        return this.color;
    }
//Naming convetion: Getters should start with get, Setters should start with set
//  Getters: public returnType getPropertyName(), Setters: public void setPropertyName(datatype value)
//For boolean fields, use isPropertyName() instead of getPropertyName().

//Static methods cannot access instance variables directly as they belong to the class, not to any instance. The method setTip should not be static.
int getTip() {
        return this.tip;
    }
    
    void setColor(String newColor) {
        this.color = newColor;
    }
    void setTip(int tip)  {   //2.new tip pass kiya hai
        this.tip = tip;       //this.tip-pen k andar ki property hai and =tip bata hai ki yeh external variable hai
    }
}

