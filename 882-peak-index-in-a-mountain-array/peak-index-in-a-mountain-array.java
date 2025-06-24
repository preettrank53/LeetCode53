class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int ans = 0;
        

        while(l<=r) {
            int mid = l + (r-l)/2;

            if(arr[mid] > arr[mid+1]) {
                ans = mid;
                r = mid-1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
}