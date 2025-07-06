//Median of Row Wise Sorted Matrix
import java.util.*;

public class Y {
    // Approach-1: Brute Force
    // TC = O(M*N + M*N*Log(M*N)), SC = O(M*N)
/*
 1. Copying elements in 1D Array
 2. Sorting the linear array of size(m*n): Array Flatening to find middle element
 */
  public static int median1(int matrix[][], int m, int n){
    List<Integer> lst = new ArrayList<>();
    for(int i =0; i<m; i++){
        for(int j =0; j<n; j++){
            lst.add(matrix[i][j]);
        }
    }
     Collections.sort(lst);
     return lst.get((m*n)/2);
  }

    // Approach-2: Using Min-Heap
    // TC = O(n.m.Log(m)), SC = O(m)
/*
 1. The matrix is row wise sorted.
 2.  Min-Heap to do a K-way merge similar to merging k sorted lists
 3. Min-heap to track smallest unprocessed elemnt frome each row.
 4. Extract min. from heap m*n/2 times.
 5. The next extracted element is median.
 */
 public static int median2(int matrix[][], int m, int n){
        class Cell{  //keep track of ele value and its pos
            int value, row, col;
            Cell(int v, int r, int c){
                value = v;
                row = r;
                col = c;
            }
        }
            PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));

            //Step1: Insert the first element from each row into heap
            //Each row is sorted so first column give smallest value. So, initially heap has m elements(one from each row)
            for(int i = 0; i<m; i++) minHeap.offer(new Cell(matrix[i][0], i, 0));

            int count = (m*n)/2;  //median
            Cell curr = null;

            //Step2: Extract min count times till we reach median
            while(count-- >= 0){
                curr = minHeap.poll();

                //Insert next element from same row if available
                if(curr.col + 1 <n) minHeap.offer(new Cell(matrix[curr.row][curr.col+1], curr.row, curr.col+1));
            }
            return curr.value; // holds the (m*n)/2-th smallest element → the median
        }

        
    // Approach-3: Binary Search
    // TC = O(Log(10^9){BS in search space} . M.LogN{upper bound for all rows}), SC = O(1)
static int upperBound3(int[] arr, int x, int n){
    int low = 0, high = n-1;
    int ans = n;

    while(low <= high){
        int mid = (low + high)/2;
        if(arr[mid] > x) {
            ans = mid;
            high = mid-1;
        } else low = mid+1;
    }
    return ans;
}

static int countSmallEqual3(int[][] matrix, int m, int n, int x){
    int cnt = 0;
    for(int i =0; i<m; i++)  cnt += upperBound3(matrix[i], x, n);
    return cnt;
}

static int median3(int[][] matrix, int m, int n){
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

    for(int i =0; i<m; i++){
        low = Math.min(low, matrix[i][0]);
        high = Math.max(high, matrix[i][n-1]);
    }
    int req = (n*m)/2;
    while(low <= high){
        int mid = (low + high)/2;
        int smallEqual = countSmallEqual3(matrix, m, n, mid);
        if(smallEqual <= req) low = mid+1;
        else high = mid-1;
    }
     return low;
 }
}
