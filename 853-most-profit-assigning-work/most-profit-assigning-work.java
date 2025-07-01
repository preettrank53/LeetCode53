import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        // Pair difficulty and profit
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        // Sort jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // Update profits to be the max so far
        for (int i = 1; i < n; i++) {
            jobs[i][1] = Math.max(jobs[i][1], jobs[i - 1][1]);
        }

        // Extract sorted difficulties and profits
        int[] sortedDifficulty = new int[n];
        int[] sortedProfit = new int[n];
        for (int i = 0; i < n; i++) {
            sortedDifficulty[i] = jobs[i][0];
            sortedProfit[i] = jobs[i][1];
        }

        Arrays.sort(worker);  // Sort workers by ability

        int totalProfit = 0, j = 0, maxProfit = 0;

        for (int i = 0; i < worker.length; i++) {
            while (j < n && sortedDifficulty[j] <= worker[i]) {
                maxProfit = Math.max(maxProfit, sortedProfit[j]);
                j++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
