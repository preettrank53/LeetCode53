class Solution {

    int maxRequest = Integer.MIN_VALUE;

    void helper(int[][] requests , int[] request , int idx , int n , int count) {

        // base case 
        if(idx == requests.length) {

            boolean allZeros = true;
            for(int i = 0 ; i<request.length ; i++) {
                if(request[i]!=0) {
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


        request[from]--;
        request[to]++;

        helper(requests , request , idx+1 , n , count+1);

        //backtrack

        request[from]++;
        request[to]--;

        helper(requests , request , idx+1 , n , count);

    }


    public int maximumRequests(int n, int[][] requests) {
        int[] request = new int[n];
        int count = 0;

        helper(requests , request , 0 , n , 0);

        return maxRequest;
    }
}