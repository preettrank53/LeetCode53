class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0 ; i< gas.length ; i++) {
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
        }

        if(totalGas < totalCost) {
            return -1;
        }

        // unique solution always exist
        int start = 0;
        int currCost = 0;

        for(int i = 0 ; i<gas.length ; i++) {
            currCost = currCost + (gas[i]-cost[i]);
            if(currCost < 0) {
                start = i + 1;
                currCost = 0 ;
            }
        }
        return start;
    }
}