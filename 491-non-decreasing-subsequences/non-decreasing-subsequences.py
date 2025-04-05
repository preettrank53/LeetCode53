class Solution(object):
    def findSubsequences(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = set()
        
        def solve(prev, i, combi):
            if i == len(nums):
                if len(combi) >= 2:
                    result.add(tuple(combi))  # Convert to tuple to store in set
                return

            if nums[i] >= prev:
                combi.append(nums[i])
                solve(nums[i], i + 1, combi)
                combi.pop()  # Backtrack

            # Also part of backtrack - skip current element
            solve(prev, i + 1, combi)
        
        solve(-101, 0, [])
        return [list(seq) for seq in result]  # Convert back to list
