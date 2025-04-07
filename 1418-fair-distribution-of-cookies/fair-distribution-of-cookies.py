class Solution(object):
    def distributeCookies(self, cookies, k):
        """
        :type cookies: List[int]
        :type k: int
        :rtype: int
        """
        self.min_unfair = float('inf')

        def backtrack(idx, children):
            if idx == len(cookies):
                self.min_unfair = min(self.min_unfair, max(children))
                return

            for i in range(k):
                children[i] += cookies[idx]
                
                backtrack(idx + 1, children)
                
                children[i] -= cookies[idx]
                
                if children[i] == 0:
                    break  # Pruning to avoid unnecessary symmetric states

        backtrack(0, [0] * k)
        return self.min_unfair
