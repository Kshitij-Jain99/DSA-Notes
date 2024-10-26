import java.util.*;
public class BSA3{
        //a

    public static void printArr(int arr[]){
        for (int i=0; i<arr.length; i++)  {
          System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length-1; i++){  //turns=i, turns count
        int minPos = i;                     //defined this, current element initially assumed
        for(int j=i+1; j<arr.length; j++) {  //unsorted part jo hai rem. array ka usme sein minimum dhund kar nikala hai
            if(arr[minPos] < arr[j]) {     //upar wali mein:j<=arr.length-1 also valid
                minPos = j;         //upar wali mein >,< sein ascending and descending order control
            }
        }              
        //swap
        int temp= arr[minPos];     //us minimum ko apni currrent position ke sath swap
        arr[minPos] = arr[i];    //we are comparing with 
        arr[i] = temp;
    }
}   
        public static void main(String args[]) {
        int arr[] = {5,4,1,3,2};
        selectionSort(arr);   //callin
        printArr(arr);

    }
}
