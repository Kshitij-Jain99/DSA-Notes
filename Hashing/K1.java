import java.util.*;

public class K1 {
    public static void main(String args[]) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);  //not added, duplciate
        set.add(1);  //not added, duplciate
        
        System.out.println(set);

       // set.remove(2);
        if(set.contains(2)) {
            System.out.println("set contains 2");
        }
        if(set.contains(3)) {
            System.out.println("set conatins 3");
        }

    }
    
}
