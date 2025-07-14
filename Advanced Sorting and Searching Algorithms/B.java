//Radix Sort
//TC = O(d.(n+10) + n) = O(d.n), SC = O(N+10) = O(N)
public class B{
    static int findMax(int[] arr){
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > mx) mx = arr[i];
        }
        return mx;
    }

    static void countSort(int[] arr, int place){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; //k-> max ele. will be 10 every time for all place pos.

        for(int i =0; i<arr.length; i++) count[ (arr[i]/place)%10 ]++;
        for(int i = 0; i<count.length; i++) count[i] += count[i-1];
        for(int i = n-1; i>=0; i--){
            int idx = count[ (arr[i]/place)%10 ] - 1;
            output[idx] = arr[i];
            count[ (arr[i]/place)%10 ]--;
        }
        for(int i = 0; i<n; i++) arr[i] = output[i];

    }

    static void radixSort(int[] arr){
        int max = findMax(arr); //get max. element
        //apply count sort to sort elements based on place value
        for(int place = 1; max/place > 0; place *= 10){ //upto 'd' no. of digits present max. number in array 
            countSort(arr, place);
        }
    }
}
