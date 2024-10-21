public class OOPS_C {
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
    private String color;
    private int tip; //1. pen ki property wala variable tip hai

    String getColor(){
        return this.color;
    }

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

