import java .util.*;

public class F1 {
    public static void main(String args[]) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China",50);
        lhm.put("US", 50);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China",50);
        hm.put("US", 50);
        
        System.out.println(lhm);   //order of input = order of output
        System.out.println(hm);
  
    }
    
}
