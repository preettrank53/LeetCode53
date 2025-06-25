import java.util.Arrays;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int m = flowers.length;
        int n = people.length;

        int[] result = new int[n];
        int[] start_time = new int[m];
        int[] end_time = new int[m];

        for (int i = 0; i < m; i++) {
            start_time[i] = flowers[i][0];
            end_time[i] = flowers[i][1];
        }

        Arrays.sort(start_time);
        Arrays.sort(end_time);

        for (int i = 0; i < n; i++) {
            int bloomed = upperBound(start_time, people[i]);
            int died = lowerBound(end_time, people[i]);
            result[i] = bloomed - died;
        }

        return result;
    }

    // upperBound: count of flowers that have bloomed (start_time <= target)
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // lowerBound: count of flowers that have died before or on target (end_time < target)
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
