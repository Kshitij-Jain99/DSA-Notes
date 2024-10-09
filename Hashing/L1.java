import java.util.*;

public class L1 {
    public static void main(String args[]) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Bengaluru");

        //A:using iterators
        Iterator it = cities.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
            //unordered output

            //B: using  advacned loops
            for(String city : cities) {  //cities collection sein ek ek karke elements aakar "city" string mein store honge
                System.out.println(city);

            }


        }
        

    }
    
}
