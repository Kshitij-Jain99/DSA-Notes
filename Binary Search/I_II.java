// Find peak Element-II

public class I_II {
    
    //Approach-1: Brute Force
    // TC = O(n*m*4), SC = O(1)
   public int[] findPeakGrid1(int[][] mat){
      int rows = mat.length;
      int cols = mat[0].length;

      for(int i = 0; i< rows; i++){
        for(int j = 0; j<cols; j++){
            int curr = mat[i][j];

            // Get neighboring values or Integer.MIN_VALUE if out of bounds
            int up = (i > 0) ? mat[i-1][j] : -1;
            int down = (i< rows-1) ? mat[i+1][j]: -1;
            int left = (j>0) ? mat[i][j-1]: -1;
            int right = (j < cols-1)? mat[i][j+1]: -1;

            //check if current element is peak
            if(curr > up && curr > down && curr > left && curr > right){
                return new int[]{i,j};
            }
        }
      }

      return new int[]{-1,-1};  //if no peak
   }

    //Approach-2: Binary Search
    // TC = O(N * LogM), SC = O(1)

    private int findMaxIndex2(int[][] mat, int n, int m, int col){ //column search
        int maxValue = -1;
        int index = -1;
        for(int i = 0; i<n; i++){
            if(mat[i][col] > maxValue){
                maxValue = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid2(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        
        int low = 0, high = m-1;
        while(low <= high){ //row iterate
            int mid = (low + high)/2;
            int maxRowIndex = findMaxIndex2(mat, n, m, mid);

            int left = (mid-1 >= 0) ? mat[maxRowIndex][mid-1] : -1;
            int right = (mid+1 < m) ? mat[maxRowIndex][mid+1] : -1;

            if(mat[maxRowIndex][mid] > left && mat[maxRowIndex][mid] > right){
                return new int[]{maxRowIndex, mid};
            } else if(mat[maxRowIndex][mid] < left) high = mid-1;
              else low = mid+1;
        } 
        return new int[]{-1,-1};
    }
}
