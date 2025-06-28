class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: only one node
        if (head == null || head.next == null) {
            return null;
        }

        int count = 1;
        ListNode node = head;

        // Count the number of nodes after head
        while (node.next != null) {
            node = node.next;
            count++;
        }

        int midIdx;
        if (count % 2 == 0) {
            midIdx = count / 2;
        } else {
            midIdx = (count - 1) / 2;
        }

        // Edge case: if midIdx == 0, delete head.next
        if (midIdx == 0) {
            head.next = head.next.next;
            return head;
        }

        // Reset to head for second traversal
        count = 0;
        node = head;
        ListNode prev = null;

        while (node != null) {
            if (count == midIdx) {
                prev.next = node.next;
                break;
            }
            prev = node;
            node = node.next;
            count++;
        }

        return head;
    }
}
