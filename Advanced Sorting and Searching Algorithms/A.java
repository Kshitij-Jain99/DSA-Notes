//Count Sort

public class A{
    //Appraoch-1: Basic Count Sort
      static void basicCountSort(int[] arr){
        int max = findMax(arr);
        int[] count = new int[max+1];
        for(int i =0; i<arr.length; i++) count[arr[i]]++;

        int k = 0;
        for(int i = 0; i<count.length; i++){
            for(int j =0; j< arr.length; j++) arr[k++] = i;
        }
      }
    static int findMax(int[] arr){
        int mx = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){ 
            if(arr[i] > mx) mx = arr[i];
        }
        return mx;
    }
    static void display(int[] a){
        for(int val: a) System.out.print(val + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {4,3,1,5,3,1,3,5};
        basicCountSort(arr);
        countSort(arr);
        display(arr);
    }

   //Appraoch-2: Better
   // TC = O(3.n + max) = O(n + k), SC = O(N + K{prefix Arr})
   static void countSort(int[] arr){
    int n = arr.length;
    int[] output = new int[n];
    int max = findMax2(arr);
        int[] count = new int[max+1];
        
        //freq array
        for(int i = 0; i<arr.length; i++) count[arr[i]]++;
        
        //prefix sum array of freq array
        for(int i =0; i<count.length; i++) count[i] += count[i-1]; //TC - max numbers present

        //Find idx of each element in original array and put it in output array
        //traversing from right to maintain stability
        for(int i = n-1; i>=0; i--){
            int idx = count[arr[i]] - 1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }

        //copy all elements of output to arr
        for(int i =0; i<n; i++) arr[i] = output[i];
   }

   static int findMax2(int[] arr){
        int mx = Integer.MIN_VALUE;
        for(int i =0; i<arr.length; i++){ 
            if(arr[i] > mx) mx = arr[i];
        }
        return mx;
    }
}