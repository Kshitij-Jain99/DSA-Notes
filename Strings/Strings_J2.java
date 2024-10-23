public class Strings_J2 {
    public static void main(String args[]) {
        String fruits[] = {"apple", "Mango", "banana"};

        String smallest = fruits[0];
        String largest = fruits[0];

        for (int i = 0; i < fruits.length; i++) {
            for (int j = i + 1; j < fruits.length; j++) {
                int comparisonResult = fruits[i].compareToIgnoreCase(fruits[j]);

                if (comparisonResult < 0) {
                    System.out.println(fruits[i] + " is less than " + fruits[j]);
                } else if (comparisonResult > 0) {
                    System.out.println(fruits[i] + " is greater than " + fruits[j]);
                } else {
                    System.out.println(fruits[i] + " is equal to " + fruits[j]);
                }

                // Update smallest and largest
                if (fruits[i].compareToIgnoreCase(smallest) < 0) {
                    smallest = fruits[i];
                }
                if (fruits[j].compareToIgnoreCase(largest) > 0) {
                    largest = fruits[j];
                }
            }
        }

        System.out.println("Smallest string: " + smallest);
        System.out.println("Largest string: " + largest);
    }
}
