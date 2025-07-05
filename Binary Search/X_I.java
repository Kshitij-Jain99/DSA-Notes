//Search in a 2D Matrix-I:
import java.util.*;

public class X_I {
    
    //Approach-1: Brute Force
    //TC = O(N + M), SC = O(1)
public static boolean searchMatrix1(ArrayList<ArrayList<Integer>> matrix, int target){
    int n = matrix.size(), m = matrix.get(0).size();

    for(int i =0; i<n; i++){
        if(matrix.get(i).get(m-1) < target) continue;
        for(int j =0; j<m; j++){
            if(matrix.get(i).get(j) == target) return true;
        }
        return false; // since rows are sorted, if not found in this row, won't be in others
    }
    return false;
}

       //Approach-2: Better
       //TC = O(N + LogM), SC = O(1)
public static boolean binarySearch2(ArrayList<Integer> matrix, int target){
    int n = matrix.size();
    int low = 0, high = n-1;

   while(low <= high){
    int mid = (low + high)/2;
    if(matrix.get(mid) == target) return true;
    else if(target > matrix.get(mid)) low = mid+1;
    else high = mid-1;
   }
    return true;
   }

   public static boolean searchMatrix2(ArrayList<ArrayList<Integer>> matrix, int target){
     int n = matrix.size();
     int m = matrix.get(0).size();

     for(int i =0; i<n; i++){
        if(matrix.get(i).get(0) <= target && target <= matrix.get(i).get(m-1))
        return binarySearch2(matrix.get(i), target);
     }
     return false;
   }

   
       //Approach-3: Best(Binary search + 2D Array Flattening)
       //TC = O(log(N*M)), SC = O(1)
public static boolean searchMatrix3(ArrayList<ArrayList<Integer>> matrix, int target){
    int n = matrix.size();
    int m = matrix.get(0).size();

    int low = 0, high = n*m - 1;
    while(low <= high){
        int mid = (low + high)/2;
        int row = mid/m, col = mid % m;
        if(matrix.get(row).get(col) == target) return true;
        else if(matrix.get(row).get(col) < target) low = mid + 1;
        else high = mid-1;
    }
    return false;
}

  }

