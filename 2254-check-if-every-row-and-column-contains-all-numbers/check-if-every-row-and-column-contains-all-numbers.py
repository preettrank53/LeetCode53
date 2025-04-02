class Solution(object):
    def checkValid(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        n = len(matrix)
        seen = set()

        for i in range(n):
            for j in range(n):
                num = matrix[i][j]

                # Create row and column checks using .format() instead of f-strings
                rowCheck = "{} in row {}".format(num, i)
                colCheck = "{} in col {}".format(num, j)

                # Check for duplicates
                if rowCheck in seen or colCheck in seen:
                    return False

                # Add constraints to the set
                seen.add(rowCheck)
                seen.add(colCheck)

        return True
