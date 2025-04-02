class Solution {

    boolean isSafe(char[][] board , int row , int col , char dig) {
        
        // check horizontal
        for(int j= 0 ; j<9 ; j++) {
            if(board[row][j]==dig) {
                return false;
            }
        }

        // check vertical
        for(int i = 0 ; i<9 ; i++) {
            if(board[i][col]==dig) {
                return false;
            }
        }

        // check in grid

        int sr = (row/3)*3;  //Starting Row of Grid...
        int sc = (col/3)*3;  //Starting Coluum of grid...

        for( int i = sr ; i<=sr+2 ; i++) {
            for(int j = sc ; j<=sc+2 ; j++) {
                if(board[i][j]==dig) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean helper(char[][] board , int row , int col ) {

        if(row==9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col+1;
        if(nextCol==9) {
            nextRow = row+1;
            nextCol = 0;
        }

        if(board[row][col] != '.') {
            return helper(board , nextRow , nextCol);
        } 

        for(char i = '1' ; i <= '9' ; i++ ) {
            if(isSafe(board,row,col,i)) {
                board[row][col] = i;
                if(helper(board,nextRow,nextCol)) {
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }

    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}