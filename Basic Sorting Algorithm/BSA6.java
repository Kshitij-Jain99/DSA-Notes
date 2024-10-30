import java.util.*;

public class BSA6 {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE; // TO GET SIZE[range] OF COUNT ARRAY, get largest
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1]; // +1 because we start from 0 and we go to n-1 index
        for (int i = 0; i < arr.length; i++) { // original array par iterate, frequency count
            count[arr[i]]++; // number ko index ki tarah lena hai, fir us index par ja kar number ko karna hai ++
        }

        // sorting
        int j = 0; // to update elements
        for (int i = 0; i < count.length; i++) { // frequency wale array par iterate
            while (count[i] > 0) {
                arr[j] = i; // count ko 0 sein start kar diya, jab tak count ki value 0 na ho jati tab tak apni
                            // original array mein us number ko dalte jayenge
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = { 1, 4, 1, 3, 2, 4, 3, 7 };
        countingSort(arr);
        printArr(arr);
    }
}