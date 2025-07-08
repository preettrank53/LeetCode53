class Solution {
    public int findPeakElement(int[] array) {
        int start = 0;
        int arrayLength = array.length;
        int end = arrayLength - 1;

        if (arrayLength < 2) {
            return 0;
        }

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            
            if (mid > 0 && mid < arrayLength - 1) {
                if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                    return mid;
                } else if (array[mid + 1] > array[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (mid == 0) {
                if (array[mid] > array[mid + 1]) {
                    return mid;
                } else {
                    start = start + 1;
                }
            } else if (mid == arrayLength - 1) {
                if (array[mid] > array[arrayLength - 2]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}