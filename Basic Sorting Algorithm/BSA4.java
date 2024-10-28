import java.util.*;

public class BSA4 {
        
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) { // Start from i=1
            int curr = arr[i];
            int prev = i - 1;
            // Finding out the correct position to insert
            while (prev >= 0 && arr[prev] < curr) { //sign change sein ascending nd descending
                arr[prev + 1] = arr[prev];
                prev--;
            } 
            // Insertion
            arr[prev + 1] = curr; // Insert curr at the correct position
        }
    }              
       
    public static void main(String args[]) {
        int arr[] = {5, 4, 1, 3, 2};
        insertionSort(arr); // calling insertionSort
        printArr(arr);
    }
}