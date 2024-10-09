import java.util.*;

public class Q1 {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String,String> revMap = new HashMap<>();  //to-from data

        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);  //to = from and from = to dataReverse 
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;   //starting point
            }
        }

        return null;   //if starting point dne but it will always exist, this is written only to remove syntax error
    }
    public static void main(String[] args) {
    HashMap<String, String> tickets = new HashMap<>(); //from-to data
    tickets.put("Chennai", "Bengaluru");
    tickets.put("Mumbai", "Delhi");
    tickets.put("Goa", "Chennai");
    tickets.put("Delhi", "Goa");

    String start = getStart(tickets);
    System.out.print(start);
    for(String key : tickets.keySet()) {
        System.out.print(" -> " +tickets.get(start));
        start = tickets.get(start);
    }

    System.out.println();

    }
}
