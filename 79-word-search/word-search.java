class Solution {

    boolean helper(char[][] board , String word , int i , int j , int n) {
        if(n == word.length()) {
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        if(i < 0 || i>= rows || j<0 || j>=cols) {
            return false;
        }

        if(board[i][j] == '$' || board[i][j] != word.charAt(n)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        if(helper(board , word , i-1 , j , n+1) ||
           helper(board , word , i+1 , j , n+1) ||
           helper(board , word , i , j-1 , n+1) ||
           helper(board , word , i , j+1 , n+1) ) {
            return true;
        }

        board[i][j] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ; j<m ; j++) {
                if(word.charAt(0) == board[i][j]) {
                    if(helper(board , word , i , j , 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}