public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        helper(n, 0, new int[n], new ArrayList<String>(), res);
        return res;
    }
    
    void helper(int n, int row, int[] assign, ArrayList<String> curr, List<List<String>> res) {
        if(row == n) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        else {
            for( int i = 0; i < n; i++ ) {
                assign[row] = i;
                if(isValid(assign, row)) {
                    StringBuilder s = new StringBuilder();
                    for(int j = 0; j < n; j++) {
                        if(j == i) s.append('Q');
                        else s.append('.');
                    }
                    curr.add(s.toString());
                    helper(n, row+1, assign, curr, res);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
    
    boolean isValid(int[] assign, int row) {
        for(int i = 0; i < row; i++) {
            if(assign[row] == assign[i] || Math.abs(assign[row]-assign[i]) == row - i) return false;
        }
        return true;
    }
}
