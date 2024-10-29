import java.util.*; //.* menas saare ke saare fxns, classs, interfaces import kr lo
  //.Arrays bhi sein yha par kam chl jayega

public class BSA5 {
        
    public static void printArr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
                  
       
    public static void main(String args[]) {
        Integer arr[] = {5, 4, 1, 3, 2};                                                                 // int arr[] = {5, 4, 1, 3, 2};
        Arrays.sort(arr,Collections.reverseOrder());                                //Arrays.sort(arr,0,3);
        printArr(arr);
    }
}