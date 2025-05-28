import java.util.*;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        if (n < 2 * k + 1) {
            // Not enough elements to form even one window
            int[] result = new int[n];
            Arrays.fill(result, -1);
            return result;
        }

        List<Integer> ans = new ArrayList<>();
        long sum = 0;
        int i = 0, j = 0;

        // First k elements can't have average
        for (int m = 0; m < k; m++) {
            ans.add(-1);
        }

        while (j < n) {
            sum += nums[j];

            if (j - i + 1 == 2 * k + 1) {
                ans.add((int)(sum / (2 * k + 1)));
                sum -= nums[i];
                i++;
            }
            j++;
        }

        // Last k elements also can't have average
        for (int m = 0; m < k; m++) {
            ans.add(-1);
        }

        // Convert list to array
        int[] result = new int[ans.size()];
        for (int x = 0; x < ans.size(); x++) {
            result[x] = ans.get(x);
        }

        return result;
    }
}
