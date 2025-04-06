class Solution(object):
    def maximumRequests(self, n, requests):
        """
        :type n: int
        :type requests: List[List[int]]
        :rtype: int
        """
        self.maxRequest = float('-inf')
        
        def helper(net, idx, count):
            if idx == len(requests):
                if all(x == 0 for x in net):
                    self.maxRequest = max(self.maxRequest, count)
                return

            from_building, to_building = requests[idx]

            # Take the current request
            net[from_building] -= 1
            net[to_building] += 1
            helper(net, idx + 1, count + 1)

            # Backtrack
            net[from_building] += 1
            net[to_building] -= 1

            # Skip the current request
            helper(net, idx + 1, count)
        
        net = [0] * n
        helper(net, 0, 0)
        return self.maxRequest
