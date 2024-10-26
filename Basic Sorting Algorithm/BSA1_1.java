import java.util.*;
public class BSA1_1{
    /**
     * @param arr
     */
    public static void bubbleSort(int arr[]) {
        int swaps=0;  // Variable to track the number of swaps
        for(int turn = 0; turn < arr.length; turn++) {
           boolean swapped=false;          // Flag to track if any swaps occurred in this pass                                             
            for(int j=0; j<=arr.length-2-turn; j++) {     //ALSO turn<arr.length-1-turn   is also valid                                                           
                if(arr[j]> arr[j+1]) {                    //j is index //current element greater than next element
                      //swap
                      int temp = arr[j];
                      arr[j] = arr[j+1];
                      arr[j+1] = temp;
                      swapped= true;
                      swaps++; // Increment the swap count

                }
            } 
            if(!swapped) {
                //if no swaps occured in this pass, this array is already sorted
                break;
            }
        } 
        System.out.println("Total swaps: " + swaps);
    }   
        

    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++)  {
          System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5};          
        bubbleSort(arr);
        printArr(arr);

    }


}
