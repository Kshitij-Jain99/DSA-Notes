import java.util.*;
public class BSA1{
    /**
     * @param arr
     */
    public static void bubbleSort(int arr[]) {
        for(int turn = 0; turn < arr.length; turn++) {                                                      
            for(int j=0; j<=arr.length-2-turn; j++) {     //ALSO turn<arr.length-1-turn   is also valid                                                           
                if(arr[j]> arr[j+1]) {                    //j is index //current element greater than next element
                      //swap
                      int temp = arr[j];
                      arr[j] = arr[j+1];
                      arr[j+1] = temp;

                }
            }
        }
    }   
        

    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++)  {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {-5,-2,0,3,2};
        bubbleSort(arr);
        printArr(arr);

    }


}
