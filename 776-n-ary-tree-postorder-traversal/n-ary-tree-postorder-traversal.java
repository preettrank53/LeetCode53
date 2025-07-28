/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> ans = new ArrayList<>();

    void postOrder(Node node) {
        if(node == null) {
            return;
        }

        for(Node child : node.children) {
            postOrder(child);
        }

        ans.add(node.val);
    }

    public List<Integer> postorder(Node root) {
        postOrder(root);
        return ans;
    }
}