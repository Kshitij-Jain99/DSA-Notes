public class DaC_C {
    
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    //Recursive Fun.
    public static void quickSort(int arr[], int si, int ei) {

        //last element-pivot, pidx pivot-index-No need of if as we have taken pIDx =ei
        if (si < ei) {
            // last element-pivot, pIdx pivot-index
            int pIdx = partition(arr, si, ei);
            if (pIdx > 0) {
                quickSort(arr, si, pIdx - 1); // left part
            }
            if (pIdx < arr.length - 1) {
                quickSort(arr, pIdx + 1, ei); // right part
            }          
    }
}

   

    public static int partition(int arr[], int si, int ei){
     int pivot = arr[ei];
     int i = si-1; ///to make places for numbers smaller than pivot

     for(int j=si; j<ei; j++) {       //j=0 is wrong as it may not start from it so use
        if(arr[j]<= pivot) {
            i++;
            //swap-elemnts other than pivot
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
      }
       //pivot swap
       i++;
       int temp= pivot;
       arr[ei] = arr[i];    //pivot = arr[i] is wrong, pivot is variable
       arr[i] = temp;
       return i;
    }
    public static void main(String args[]) {
        int arr[] = {6,3,9,8,2,5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}

