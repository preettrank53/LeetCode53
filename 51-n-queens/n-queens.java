class Solution {

    boolean isSafe(List<String> board , int row , int col , int n) {  // O(n)
        // horizontal
        for(int j = 0 ; j<n ; j++) {
            if(board.get(row).charAt(j) == 'Q') {
                return false;
            }
        }

        //vertical
        for(int i = 0 ; i<n ; i++) {
            if(board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // left diagonal
        for(int i=row-1,j = col-1 ; i>=0 && j>=0 ; i-- , j--) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        //right diagonal
        for(int i=row-1,j = col+1 ; i>=0 && j< n ; i-- , j++) {
            if(board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    } 

    void nQueen( List<String> board , int row , int n , List<List<String>> result ) {
        if(row == n) {
            result.add(new ArrayList(board));
            return;
        }

        for(int j = 0 ; j < n ; j++) {
            if(isSafe(board , row , j , n)) {
                char[] charArray = board.get(row).toCharArray();
                charArray[j] = 'Q';                         // board[row][j]='Q';
                board.set(row, new String(charArray));

                nQueen(board, row + 1, n, result);          // nQueen(board , row+1 , n , result);

                // Backtrack
                charArray[j] = '.';
                board.set(row, new String(charArray));       //  board[row][j]='.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> board = new ArrayList<>();

        // Initialize board with empty rows
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        nQueen(board , 0 , n , result);

        return result;


    }
}