public class Strings_J1 {
    public static void main(String args[]) {
        String fruits[] = {"apple", "Mango", "banana"};

        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {
            if (largest.compareToIgnoreCase(fruits[i]) < 0) { // Compare strings ignoring case
                largest = fruits[i];
            }
        }
        System.out.println("The largest string (case-insensitive) is: " + largest);
    }
}
