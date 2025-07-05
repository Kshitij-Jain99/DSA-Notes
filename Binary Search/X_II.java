//Search in a 2D Matrix-II:

import java.util.ArrayList;

public class X_II {

    //Approach-1: Brute Force
    //TC = O(N*M), SC = O(1)

public static boolean searchMatrix1(ArrayList<ArrayList<Integer>> matrix, int target){
    int n = matrix.size(), m = matrix.get(0).size();
    for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == target)
                    return true;
            }
        }
    return false;
}
    
    //Approach-2: Binary Search
    //TC = O(N.LogM), SC = O(1)
public static boolean searchMatrix2(ArrayList<ArrayList<Integer>> matrix, int target){
    int n = matrix.size();
    int m = matrix.get(0).size();

    for(int i =0; i<n; i++){
        boolean flag = binarySearch2(matrix.get(i), target);
        if(flag == true) return true;
    }
    return false;
  }
  public static boolean binarySearch2(ArrayList<Integer> matrix, int target){
    int n = matrix.size(); 
    int low = 0, high = n - 1;

    while(low <= high){
        int mid = (low + high)/2;
        if(matrix.get(mid) == target) return true;
        else if(target > matrix.get(mid)) low = mid+1;
        else high = mid-1;
    }
    return false;

   }

    //Approach-3: Top-right search  
    //TC = O(N+M), SC = O(1)
 public static boolean searchElement3(ArrayList<ArrayList<Integer>> matrix, int target) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int row = 0, col = m - 1;

        //traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) row++;
            else col--;
        }
        return false;
    }
}