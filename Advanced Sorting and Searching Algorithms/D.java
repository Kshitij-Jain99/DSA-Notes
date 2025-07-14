//Set characters by frequency
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D {
    //Approach-1: Sorting
    //TC = O(n+n.logn), SC = O(n)
    public String frequencySort(String s){
        //Count frequency of each character
        int[] freq = new int[128];
        for(char ch: s.toCharArray()) freq[ch]++;

        //Convert string to Character array for sorting
        Character[] chars = new Character[s.length()];
        for(int i =0; i<s.length(); i++) chars[i] = s.charAt(i);

        //Sort using a custom comparator
        Arrays.sort(chars, (a,b) -> {
            if(freq[a] == freq[b]) return a-b;
            else return freq[b] - freq[a];
        });

        //Convert back to string
        StringBuilder sb = new StringBuilder();
        for(char ch: chars) sb.append(ch);
        return sb.toString();
    }

    //Approach-2: Sorting only k distinct characters(26 LC + 26 UC + 10 Digits)
    //TC = O(n + k.logk), SC = O(n+k)
    // e.g "aabbb"->5 Characters sort, now only a, b -> 2 Characters sort
   public String frequencySort2(String s) {
        //Count frequency of each character using HashMap
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        //Convert HashMap entries to a List for sorting
        List<Map.Entry<Character, Integer>> freqList = new ArrayList<>(freq.entrySet());

        // Sort the list in descending order of frequency
        freqList.sort((a, b) -> b.getValue() - a.getValue());

        // Build the result string by repeating characters according to their frequency
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : freqList) {
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }

    //Approach-3: Bucket Sort
    //TC = O(n), SC = O(n)
public static String frequencySort3(String s){
    //count freq of each character
    Map<Character, Integer> freq = new HashMap<>();
    for(char ch: s.toCharArray()) freq.put(ch, freq.getOrDefault(ch, 0) + 1);

    //Create buckets(index = frequency)
    List<Character>[] buckets = new List[s.length()+1];
    for(char ch: freq.keySet()){
        int fq = freq.get(ch);
        if(buckets[fq] == null){
            buckets[fq] = new ArrayList<>();
        }
        buckets[fq].add(ch);
    }

    //Build the result string
    StringBuilder ans = new StringBuilder();
    for(int fq = buckets.length - 1; fq >= 1; fq--){
        if(buckets[fq] != null){
            for(char ch: buckets[fq]){
                for(int i = 0; i< fq; i++) ans.append(ch);
            }
        }
    }
    return ans.toString();
 }
}
   



