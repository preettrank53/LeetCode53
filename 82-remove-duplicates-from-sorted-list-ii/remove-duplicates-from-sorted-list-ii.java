class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);

        ListNode curr = head;
        ListNode dmy = dummy;

        while(curr != null) {
            if(curr.next != null && curr.val == curr.next.val) {
                while(curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
            }
            else {
                dmy.next = curr;
                dmy = dmy.next;
                curr = curr.next;
            }
        }
        dmy.next = null;
        return dummy.next;
    }
}