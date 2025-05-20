class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < n; i++) {
            map.put(nums1[i], -1);
        }

        for (int i = 0; i < m; i++) {
            if (map.containsKey(nums2[i])) {
                for (int j = i + 1; j < m; j++) {
                    if (nums2[j] > nums2[i]) {
                        map.put(nums2[i], nums2[j]);
                        break;
                    }
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
