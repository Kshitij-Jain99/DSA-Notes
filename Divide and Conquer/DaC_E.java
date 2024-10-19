public class DaC_E {
    public static int search(int arr[], int tar, int si, int ei) {
        //base case-if the element does not exist in array
        if(si>ei) {
            return -1;
        }
        //kaam
        int mid= si+ (ei-si)/2;

        //case Found
        if(arr[mid]== tar) {
            return mid;
        }

        //mid on line-1
        if(arr[si]<= arr[mid]) {
            //case a: left
            if(arr[si]<= tar&& tar <= arr[mid]) {
                return search(arr, tar, si, mid-1);
            }else{
                //caase-b:Right
                return search(arr, tar, mid+1, ei);
            }
        }
        //mid on L2
        else{
             //case-c:Right
             if(arr[mid]<= tar && tar>= arr[si]){
                return search(arr, tar, mid+1, ei);
        }
        
       }
        return mid;
    }

    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;   //output--->4
        int tarIdx = search(arr, target,0,arr.length-1);
        System.out.println(tarIdx);
    }
}