class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        int n = arr.length;

        Arrays.sort(arr);

        int i = 0 , j = n-1 ;
        int boats = 0;

        while(i<=j) {
            if(arr[j]+arr[i] <= limit) {
                i++;
                j--;
                boats++;
            } else {
                j--;
                boats++;
            }
        }
        return boats;
    }
}