class Solution {

    boolean isSafe(List<String> board , int n , int col , int row) {
        for(int j = 0 ; j<n ; j++) {
            if(board.get(row).charAt(j) == 'Q') {
                return false;
            }
        }

        for(int i = 0 ; i<n ; i++) {
            if(board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }


        return true;
    }

    void helper(int n , List<List<String>> list , List<String> board , int row) {
        if(row == n) {
            list.add(new ArrayList<>(board));
            return;
        }

        for(int j = 0 ; j<n ; j++) {
            if(isSafe(board , n , j , row)) {
                char ch[] = board.get(row).toCharArray();
                ch[j] = 'Q';
                board.set(row , new String(ch));

                helper(n , list , board , row+1);

                ch[j] = '.';
                board.set(row , new String(ch));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for(int i = 0 ; i<n ; i++) {
            board.add(".".repeat(n));
        }

        helper(n , list , board , 0);

        return list;
    }
}