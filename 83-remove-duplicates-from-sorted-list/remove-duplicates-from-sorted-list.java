class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        List<Integer> list = new LinkedList<>();
        ListNode curr = head;

        while (curr != null) {
            if (!list.contains(curr.val)) {
                list.add(curr.val);
            }
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode newCurr = dummy;

        for (int val : list) {
            newCurr.next = new ListNode(val);
            newCurr = newCurr.next;
        }

        return dummy.next;
    }
}
