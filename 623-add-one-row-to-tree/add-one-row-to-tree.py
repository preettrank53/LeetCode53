# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def addOneRow(self, root, val, depth):
        """
        :type root: Optional[TreeNode]
        :type val: int
        :type depth: int
        :rtype: Optional[TreeNode]
        """
        if depth == 1:
            newRoot = TreeNode(val)
            newRoot.left = root
            return newRoot

        queue = [root]
        level = 1

        while queue:
            size = len(queue)
            if level == depth - 1:
                for i in range(size):
                    node = queue.pop(0)

                    tempLeft = node.left
                    tempRight = node.right

                    node.left = TreeNode(val)
                    node.right = TreeNode(val)

                    node.left.left = tempLeft
                    node.right.right = tempRight

                break

            for i in range(size):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)

            level += 1

        return root
