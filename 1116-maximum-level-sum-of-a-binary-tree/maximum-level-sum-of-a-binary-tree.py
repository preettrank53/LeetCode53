class Solution(object):
    def maxLevelSum(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        if not root:
            return 0

        from collections import deque

        queue = deque([root])
        level = 1
        max_level = 1
        max_sum = float('-inf')

        while queue:
            n = len(queue)
            current_sum = 0

            for _ in range(n):
                node = queue.popleft()
                current_sum += node.val

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            if current_sum > max_sum:
                max_sum = current_sum
                max_level = level

            level += 1

        return max_level

