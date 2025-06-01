// String Buffer: Constructors and Basic Methods

public class A1 {
    public static void main(String[] args){
        
        //Constructor-1
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());

        //Constructor-2
        StringBuffer sb2 = new StringBuffer("Kain");

        //Constructor-3: Capacity specified, by deafult it is 16
        StringBuffer sb3 = new StringBuffer(30);  
        System.out.println(sb.capacity());
        
        sb.append("WeMakeDevs");
        sb.append(" is a great platform");
        sb.insert(2, "Rahul");
        sb.replace(1,5, "Damm"); //Eidx is exclusive, Sidx is inclusive
        sb.delete(2, 5); //Eidx is exclusive, Sidx is inclusive
        sb.reverse();

        String str = sb.toString();
        System.out.println(str);
    }
}
