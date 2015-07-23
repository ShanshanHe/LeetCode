/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

/*
O(m+n)
m: number of rows
n: number of cols
The search starts from the left-bottom coner of the matrix, eliminating either one row or one col at a time
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j<matrix[0].length){
            if(matrix[i][j] == target) return true;
            else if(target > matrix[i][j]) j++;
            else i--;
        }
        return false;
    }
}
