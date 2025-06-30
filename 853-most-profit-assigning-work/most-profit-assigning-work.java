class Solution {

    private int getMaxProfit(int[] difficulties, int[] profits, int ability) {
        int left = 0, right = difficulties.length - 1;
        int maxProfit = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (difficulties[mid] <= ability) {
                maxProfit = profits[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxProfit;
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;

        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < n; i++) {
            jobs[i][1] = Math.max(jobs[i][1], jobs[i - 1][1]);
        }

        int[] sortedDifficulty = new int[n];
        int[] sortedProfit = new int[n];
        for (int i = 0; i < n; i++) {
            sortedDifficulty[i] = jobs[i][0];
            sortedProfit[i] = jobs[i][1];
        }

        int totalProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            totalProfit += getMaxProfit(sortedDifficulty, sortedProfit, worker[i]);
        }

        return totalProfit;
    }
}
