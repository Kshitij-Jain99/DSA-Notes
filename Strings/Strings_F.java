public class Strings_F {

    public static boolean isPalindrome(String str) {
        int n = str.length(); // Calculate the length of the string only once for efficiency
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                // If characters don't match, it's not a palindrome
                return false;
            }
        }
        // If the loop completes without returning false, it's a palindrome
        return true;
    }

    public static void main(String args[]) {
        String str = "kshitij";

        if (isPalindrome(str)) {
            System.out.println(str + " is a palindrome.");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }
}
