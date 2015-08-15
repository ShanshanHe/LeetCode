/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

/*
x,y is the last character of word1 and word2.
if x == y, then dp[i][j] == dp[i-1][j-1]
if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1
if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1
if x != y, and we replace x with y for word1, then dp[i][j] = dp[i-1][j-1] + 1
When x!=y, dp[i][j] is the min of the three situations.
*/
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0) return n;
        if(n == 0) return m;
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; ++i) dp[i][0] = i;
        for(int i = 0; i <= n; ++i) dp[0][i] = i;
        for(int i = 0; i < m; ++i) for(int j = 0; j < n; ++j){
            if(word1.charAt(i) == word2.charAt(j)) dp[i+1][j+1] = dp[i][j];
            else dp[i+1][j+1] = minInThree(dp[i+1][j]+1, dp[i][j+1]+1, dp[i][j]+1);
        }
        return dp[m][n];
    }
    
    private int minInThree(int i, int j, int k) {
        int min = Math.min(i,j);
        min = Math.min(min, k);
        return min;
    }
}
