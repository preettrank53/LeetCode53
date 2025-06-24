class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] temp = new int[n+m];

        int i = 0 ; 
        int j = 0 ;
        int k = 0 ; 

        while(i<n && j<m) {
            if(nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
                k++;
            }
            else {
                temp[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(i<n) {
            temp[k]=nums1[i];
            i++;
            k++;
        }
        while(j<m) {
            temp[k]=nums2[j];
            j++;
            k++;
        }

        //double ans = 0.0;
        int tempSize = m+n;

        if((m+n) % 2 == 0) {
            return (temp[tempSize/2] + temp[(tempSize/2)-1])/2.0; 
        }

        return temp[tempSize/2];
    }
}