class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;

        ListNode curr = pre.next;

        while (curr != null) {
            if (pre.val == curr.val) {
                ListNode currTemp = curr;
                curr = curr.next;
                currTemp.next = null;

            } else {
                pre.next = curr;
                pre = curr;
                curr = curr.next;
            }
        }
        pre.next = null;

        return head;
    }
}