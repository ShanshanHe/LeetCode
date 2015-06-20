public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row*col-1;
        return searchMatrix(matrix,0,n,target,col);
    }
    
    boolean searchMatrix(int[][] matrix, int l, int r, int target, int col) {
        if(l > r) return false;
        int mid = (l+r)/2;
        int m = mid/col;
        int n = mid%col;
        if(matrix[m][n] == target) return true;
        else if(target > matrix[m][n]) return searchMatrix(matrix,mid+1,r,target,col);
        else return searchMatrix(matrix,l,mid-1,target,col);
    }
}
