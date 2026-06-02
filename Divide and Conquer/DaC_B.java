// Merge Sort

public class DaC_B {

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;         // iterator for the left part
        int j = mid + 1;    // iterator for the right part
        int k = 0;          // iterator for the temp array

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Left-out elements of the other part when one part's elements were exhausted
        while (i <= mid)  temp[k++] = arr[i++];
        while (j <= ei)   temp[k++] = arr[j++];

        // Copy temp to the original array
        for (k = 0, i = si; k < temp.length; k++, i++)   arr[i] = temp[k];
    }

    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei)   return;

        // Work
        int mid = si + (ei - si) / 2; 
        mergeSort(arr, si, mid);        // left part
        mergeSort(arr, mid + 1, ei);    // right part
        merge(arr, si, mid, ei);
    }


    public static void main(String args[]) {
        int arr[] = {6, 3, 9, 5, 2, 8, -2};       //odd number of elements
        mergeSort(arr, 0, arr.length - 1);
    }
}
