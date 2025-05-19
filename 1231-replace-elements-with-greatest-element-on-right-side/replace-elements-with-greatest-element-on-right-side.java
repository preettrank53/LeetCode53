class Solution {
    
    int max(int[] arr , int i) {
        int max = arr[i];

        for(int j = i + 1 ; j<arr.length ; j++ ) {
            if(max < arr[j]) {
                max = arr[j];
            }
        }

        return max;
    }
    public int[] replaceElements(int[] arr) {

        for(int i = 0 ; i<arr.length-1 ; i++) {
            arr[i] = max(arr , i+1);
        }

        arr[arr.length-1] = -1;
        return arr;
    }
}