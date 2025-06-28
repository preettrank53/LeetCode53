/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // Helper to merge two sorted linked lists
    ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = merge2List(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2List(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode merged = lists[0];

        for (int i = 1; i < lists.length; i++) {
            merged = merge2List(merged, lists[i]);
        }

        return merged;
    }
}
