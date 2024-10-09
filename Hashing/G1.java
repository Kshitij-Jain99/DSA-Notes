import java .util.*;

public class G1 {
    public static void main(String args[]) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China",50);
        tm.put("US", 50);
        tm.put("Indonesia", 180);

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China",50);
        hm.put("US", 50);
        
        System.out.println(tm);   //sorted keys in alphabetical order
        System.out.println(hm);
  
    }
    
}
