class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        seen = []  # Using a list instead of a set

        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num == '.':
                    continue  # Skip empty cells
                
                # Create strings using .format() instead of f-strings
                rowCheck = "{} in row {}".format(num, i)
                colCheck = "{} in col {}".format(num, j)
                boxCheck = "{} in box {}-{}".format(num, i // 3, j // 3)

                # Check if the number already exists in the list
                if rowCheck in seen or colCheck in seen or boxCheck in seen:
                    return False  # Duplicate found
                
                # Add constraints to the list
                seen.append(rowCheck)
                seen.append(colCheck)
                seen.append(boxCheck)

        return True  # Sudoku is valid
