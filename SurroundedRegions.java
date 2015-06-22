public class Solution {
    /*
    ** dfs. 
    ** large board will cause java.lang.StackOverflowError
    ** too many method calls will be pushed to stack
    */
    /*
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows == 0) return;
        int cols = board[0].length;
        if(rows == 1 || cols == 1) return;
        
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') helper(board, 0, i);
            if(board[rows-1][i] == 'O') helper(board, rows-1, i);
        }
        
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') helper(board, i, 0);
            if(board[i][cols-1] == 'O') helper(board, i, cols-1);
        }
        
        for(int i = 0; i < rows; i++) for(int j = 0; j < cols; j++) {
            if(board[i][j] == 'O') board[i][j] = 'X';
            else if(board[i][j] == '#') board[i][j] = 'O';
        }
    }
    
    void helper(char[][] board, int row, int col) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if(board[row][col] != 'O') return;
        board[row][col] = '#';
        helper(board, row-1, col);
        helper(board, row+1, col);
        helper(board, row, col-1);
        helper(board, row, col+1);
    }
    */
    
    /*
    ** bfs
    */
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        //first column and last column
        for(int i = 0; i < rows; i++) {
            if(board[i][0] == 'O') queue.add(i*cols);
            if(board[i][cols-1] == 'O') queue.add(i*cols+cols-1);
        }
        
        //first row and last row
        for(int i = 0; i < cols; i++) {
            if(board[0][i] == 'O') queue.add(i);
            if(board[rows-1][i] == 'O') queue.add((rows-1)*cols+i);
        }
        
        while(!queue.isEmpty()) {
            int pos = queue.poll();
            int row = pos/cols;
            int col = pos%cols;
            board[row][col] = '#';
            if(row-1 >= 0 && board[row-1][col] == 'O') queue.add((row-1)*cols+col);
            if(row+1 < rows && board[row+1][col] == 'O') queue.add((row+1)*cols+col);
            if(col-1 >= 0 && board[row][col-1] == 'O') queue.add(row*cols+col-1);
            if(col+1 < cols && board[row][col+1] == 'O') queue.add(row*cols+col+1);
        }
        
        for(int i = 0; i < rows; i++) for(int j = 0; j < cols; j++) {
            if(board[i][j] == 'O') board[i][j] = 'X';
            else if(board[i][j] == '#') board[i][j] = 'O';
        }
    }
}
