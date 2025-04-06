class Solution {

    int maxRequest = Integer.MIN_VALUE;

    void helper(int[][] requests , int[] net , int idx , int n , int count) {

        // base case 
        if(idx == requests.length) {

            boolean allZeros = true;
            for(int i = 0 ; i<net.length ; i++) {
                if(net[i]!=0) {
                    allZeros = false;
                    break;
                }
            }

            if(allZeros==true) {
                maxRequest = Math.max(maxRequest , count);
            }
                return;
        }

        int from = requests[idx][0];
        int to = requests[idx][1];


        net[from]--;
        net[to]++;

        helper(requests , net , idx+1 , n , count+1);

        //backtrack

        net[from]++;
        net[to]--;

        helper(requests , net , idx+1 , n , count);

    }


    public int maximumRequests(int n, int[][] requests) {
        int[] net = new int[n];
        int count = 0;

        helper(requests , net , 0 , n , 0);

        return maxRequest;
    }
}