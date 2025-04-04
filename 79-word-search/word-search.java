class Solution {

    boolean dfs(char[][] board , int r , int c , String word , int wordIndex) {
        //base case
        if(wordIndex==word.length()){
            return true;
        }    

        // out of bound case 
        int rows = board.length;
        int cols = board[0].length;

        if(r<0 || r>=rows || c<0 || c>=cols) {
            return false;
        }

        // invalide case
        if(board[r][c]=='$' || board[r][c]!=word.charAt(wordIndex)) {
            return false;
        }

        char ch = board[r][c];
        board[r][c]='$'; 

        // dfs calls 
        if(dfs(board ,r-1 , c , word , wordIndex+1) ||
           dfs(board ,r , c+1 , word , wordIndex+1) ||
           dfs(board ,r+1 , c , word , wordIndex+1) ||
           dfs(board ,r , c-1 , word , wordIndex+1)  ) {
            return true;
        }

        // backtraking
        board[r][c]=ch;
        return false;


    }


    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0 ; i<n ; i++) {
            for(int j = 0 ;j<m ; j++) {
                if(word.charAt(0)==board[i][j]) {
                    boolean found = dfs(board,i,j,word,0);
                    if(found) {
                        return true;
                    }
                }
            }

        }
        return false;
    }
}