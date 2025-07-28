class Solution {

    void PreOrder(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);

        for (Node child : root.children) {
            PreOrder(child, list);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        PreOrder(root, list);
        return list;
    }

    
}