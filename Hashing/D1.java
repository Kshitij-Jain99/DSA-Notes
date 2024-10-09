import java.util.*;

public class D1 {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 100);
        hm.put("US", 100);
        hm.put("Indonesia", 100);
        hm.put("Nepal", 100);

        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("keys = "+k+", value = "+hm.get(k));
            
        }

    }
}
