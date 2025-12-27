class Solution {

    double helper(double x , long n) {
        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return helper(1/x , -n);
        }

        if(n % 2 == 0) {
            return helper(x * x , n/2);
        }
        else {
            return x * helper(x * x , (n-1)/2);
        }
    }

    public double myPow(double x, int n) {
        return helper(x , (long)n);
    }
}