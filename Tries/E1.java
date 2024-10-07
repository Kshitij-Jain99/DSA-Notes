public class E1 {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // insert
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // Search
    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true; // second part empty ho gya so, check only for first part
        }
        for (int i = 1; i <= key.length(); i++) {
            // substring(0,end idx) [end idx is non inclusive so we intialized i=1]

            if (search(key.substring(0, i)) && // first part of string check if it exist then call wordBreak fxn
                wordBreak(key.substring(i))) { // second part of string //no need to write end idx, in java by default it will run upto end idx
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        String arr[] = { "i", "like", "sam", "samsung", "mobile", "ice" };
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        String key = "ilikesamsung";
        System.out.println(wordBreak(key));
    }
}
