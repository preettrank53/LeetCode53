class Solution {

    boolean helper(int n , int[] batteries , long mid) {
        long sum = 0;
        long sum1 = 0;
        long finalSum =0;
        for(int i = 0; i<batteries.length ; i++) {
            long wantMIN = batteries[i] - mid;
            if(wantMIN >= 0) {
                sum1 = sum1 + mid;
            }else {
                sum = sum + batteries[i];
            } 
        }
        finalSum = sum1 + sum;
        if(finalSum >= n*mid ) {
            return true;
        }
        return false;
    }

    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;

        long l = 0;
        long r = 0;
        for(int i = 0 ; i<m ; i++) {
            r=r+batteries[i];
        }
        long ans = 0;

        while(l<=r) {
            long mid = (long)l + (r-l)/2;

            if(helper(n , batteries , mid)) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}