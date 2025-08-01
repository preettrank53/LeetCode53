class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else {
            map.put(node.val, 1);
        }

        helper(node.left);
        helper(node.right);
    }

    public int[] findMode(TreeNode root) {
        helper(root);

        int maxFreq = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                list.add(key);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
