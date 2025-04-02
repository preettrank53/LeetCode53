class Solution(object):
    def solveSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: None Do not return anything, modify board in-place instead.
        """
        # Using sets to track numbers in rows, columns, and 3x3 grids
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        grids = [set() for _ in range(9)]
        empty_cells = []
        
        # Preprocessing: Store existing numbers and track empty cells
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = board[i][j]
                    rows[i].add(num)
                    cols[j].add(num)
                    grids[(i // 3) * 3 + (j // 3)].add(num)
                else:
                    empty_cells.append((i, j))  # Store empty cell positions
        
        def backtrack(index):
            if index == len(empty_cells):  # All cells are filled, Sudoku solved
                return True
            
            row, col = empty_cells[index]
            grid_idx = (row // 3) * 3 + (col // 3)
            
            for num in map(str, range(1, 10)):  # Try placing numbers '1' to '9'
                if num not in rows[row] and num not in cols[col] and num not in grids[grid_idx]:
                    # Place the number
                    board[row][col] = num
                    rows[row].add(num)
                    cols[col].add(num)
                    grids[grid_idx].add(num)
                    
                    if backtrack(index + 1):  # Recur for next cell
                        return True
                    
                    # Undo placement (backtracking)
                    board[row][col] = '.'
                    rows[row].remove(num)
                    cols[col].remove(num)
                    grids[grid_idx].remove(num)
            
            return False  # No valid number found
        
        backtrack(0)
