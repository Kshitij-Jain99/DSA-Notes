import java.util.ArrayList;
import java.util.Collections;
//Allocate Minimum Number of Pages

public class R {
 
    //Approach-1: Brute Force
    //TC = O(N + (sum(arr[]) - max(arr[])+1)), SC = O(1)
public static int countStudents1(ArrayList<Integer> arr, int pages){
    int n = arr.size();
    int students = 1;
    long pagesStudent = 0;
    for(int i = 0; i<n; i++){
        if(pagesStudent + arr.get(i) <= pages){
            pagesStudent += arr.get(i); //add pages to current student
        }
        else{ //add pages to next student
            students++;
            pagesStudent = arr.get(i);
        }
    }
    return students;
  }
public static int findPages1(ArrayList<Integer> arr, int n, int m){
    if(m > n) return -1;
    int low = Collections.max(arr);   //or int low = arr.stream().max(Integer::compare).get();
    int high = arr.stream().mapToInt(Integer:: intValue).sum(); //sice arr is ArrayList
    // (if arr is an int[] instead of List<Integer> :  int high = Arrays.stream(arr).sum(); -> better than above
/* compute low and high in single parse, no stream overhead, better
 int low = Integer.MIN_VALUE, high = 0;
for (int num : arr) {
    if (num > low) low = num;
    high += num;
}
 */
    for(int pages = low; pages <= high; pages++){
        if(countStudents1(arr, pages) == m) return pages;
    }
    return low;
 }

    //Approach-2: Binary Search
    //TC = O(N * log(sum(arr[]) - max(arr[]) + 1)), SC = O(1)
public static int countStudents2(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPage2(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents2(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
