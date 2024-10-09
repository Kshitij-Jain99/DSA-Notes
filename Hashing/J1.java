import java.util.*;

public class J1 {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

            for(int i=0; i<t.length(); i++ ) {
                char ch = t.charAt(i);

                if(map.get(ch) != null) {   // given ch exist in map
                    if(map.get(ch) == 1) { //freq. = 1, so directly remove
                        map.remove(ch);
                    } else {
                        map.put(ch, map.get(ch) -1 );   //freq>1, then decrease it by 1
                    }
                } else {   //given ch dne in map
                    return false;
                }
            }
            
            return map.isEmpty();
       
    }
    public static void main(String args[]) {
        String s = "mess";
        String t = "care";

        System.out.println(isAnagram(s,t) );

    }
    
}
