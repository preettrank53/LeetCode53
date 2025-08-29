class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return minCuts(s,0,dp);
    }

    public int minCuts(String str,int j,int[] dp)
    {

        if(j >= str.length()){
            return -1;
        }
        if(dp[j] != -1){
            return dp[j];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=j;i<str.length();i++)
        {
            if(isPalin(str.substring(j,i+1)))
            {
                ans = Math.min(ans,1 + minCuts(str,i+1,dp));
            }

        }

        return dp[j] = ans;
    }

  public boolean isPalin(String str) {
    int left = 0, right = str.length() - 1;

    while (left < right) {
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
}