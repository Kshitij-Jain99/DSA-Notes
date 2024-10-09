import java.util.*;

public class C1 {
    public static void main(String args[]) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();

        //insert or put
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        //get
        int population = hm.get("India");
        System.out.println(population);

        //containsKey
        System.out.println(hm.containsKey("India"));  //T
        System.out.println(hm.containsKey("Indonesia"));  //f

        //REMOVE
        System.out.println(hm.remove("China"));
        System.out.println(hm.remove("Indonesia"));
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //isEmpty
        System.out.println(hm.isEmpty());

        //clear
        hm.clear();
        System.out.println(hm.isEmpty());

 
    }
}
