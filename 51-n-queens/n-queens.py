class Solution(object):
    def isSafe(self, board, row, col, n):
        # horizontal
        for j in range(n):
            if board[row][j] == 'Q':
                return False

        # vertical
        for i in range(n):
            if board[i][col] == 'Q':
                return False

        # left diagonal
        for i, j in zip(range(row - 1, -1, -1), range(col - 1, -1, -1)):
            if board[i][j] == 'Q':
                return False

        # right diagonal
        for i, j in zip(range(row - 1, -1, -1), range(col + 1, n)):
            if board[i][j] == 'Q':
                return False

        return True

    def nQueen(self, board, row, n, result):
        if row == n:
            result.append(["".join(row) for row in board])  # Add valid solution
            return

        for j in range(n):
            if self.isSafe(board, row, j, n):
                board[row][j] = 'Q'  # Place the queen

                self.nQueen(board, row + 1, n, result)  # Recur to place the next queen

                # Backtrack
                board[row][j] = '.'  # Reset the position

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result = []
        board = [['.' for _ in range(n)] for _ in range(n)]  # Initialize board with empty rows

        self.nQueen(board, 0, n, result)

        return result
