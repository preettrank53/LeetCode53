class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;

        Arrays.sort(tokens);

        int i = 0 , j = n-1;

        int score = 0 ;
        int maxScore = 0 ;

        while(i<=j) {
            if(power >= tokens[i]) {
                power = power - tokens[i];
                score++;
                i++;
                maxScore = Math.max(maxScore , score);
            }
            else if(score >= 1) {
                power = power + tokens[j];
                score--;
                j--;
            }
            else {
                return maxScore;
            }
        }

        return maxScore;
    }
}