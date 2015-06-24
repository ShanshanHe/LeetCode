public class Solution {
    
    /*
    ** dfs + cached data
    */
    /*
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m+1][n+1];
        return helper(paths, m, n);
    }
    
    int helper(int[][] paths, int m, int n) {
        if( m == 0 || n == 0 ) return 0;
        if( m == 1 && n == 1 ) return 1;
        return getOrUpdate(paths, m-1, n) + getOrUpdate(paths, m, n-1);
    }
    
    int getOrUpdate(int[][] paths, int m, int n) {
        if(paths[m][n] > 0) return paths[m][n];
        else {
            paths[m][n] = helper(paths,m,n);
            return paths[m][n];
        }
    }
    */
    
    /*
    ** dynamic programming
    */
    public int uniquePaths(int m, int n) {
        if( m == 0 || n == 0) return 0;
        int[][] paths = new int[m+1][n+1];
        paths[1][1] = 1;
        for(int i = 1; i <= m; i++) for(int j = 1; j <= n; j++) {
            if(i==1 && j==1) continue;
            paths[i][j] = paths[i-1][j] + paths[i][j-1];
        }
        return paths[m][n];
    }
}
