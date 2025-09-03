class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int m = t.length();

        int cost = 0;
        int ans = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;

        while(j < n) {
            cost = cost + Math.abs(s.charAt(j) - t.charAt(j));

            while(cost > maxCost ) {
                cost = cost - Math.abs(s.charAt(i) - t.charAt(i));

                i++;
            }

            ans = Math.max(ans , j-i+1);
            j++;
        }

        return ans;
    }
}