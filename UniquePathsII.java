public class Solution {
    /*
    ** dfs
    */
    /*
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m+1][n+1];
        return helper(obstacleGrid, paths, m, n);
    }
    
    int helper(int[][] obstacleGrid, int[][] paths, int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(obstacleGrid[m-1][n-1] == 1) return 0;
        if(m == 1 && n == 1) return 1;
        return getOrUpdate(obstacleGrid, paths, m-1, n) + getOrUpdate(obstacleGrid, paths, m, n-1);
    }
    
    int getOrUpdate(int[][] obstacleGrid, int[][] paths, int m, int n) {
        if(paths[m][n] > 0) return paths[m][n];
        else {
            paths[m][n] = helper(obstacleGrid, paths, m, n);
            return paths[m][n];
        }
    }
    */
    /*
    ** dp
    */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m+1][n+1];
        paths[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for(int i = 1; i <= m; i++) for(int j = 1; j <= n; j++) {
            if(i == 1 && j == 1) continue;
            if(obstacleGrid[i-1][j-1] == 1) paths[i][j] = 0;
            else paths[i][j] = paths[i-1][j] + paths[i][j-1];
        }
        return paths[m][n];
    }
}
