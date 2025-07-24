class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dmyHead = dummy;

        while (dmyHead.next != null && dmyHead.next.next != null) {
            ListNode first = dmyHead.next;
            ListNode second = dmyHead.next.next;

            // Swap
            first.next = second.next;
            second.next = first;
            dmyHead.next = second;

            // Move to the next pair
            dmyHead = first;
        }

        return dummy.next;
    }
}
