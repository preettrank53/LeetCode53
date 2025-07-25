class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dmyCurr1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode dmyCurr2 = dummy2;

        ListNode curr = head;

        while(curr != null) {
            if(curr.val < x) {
                dmyCurr1.next = curr;
                curr = curr.next;
                dmyCurr1 = dmyCurr1.next;
            }
            else {
                dmyCurr2.next = curr;
                curr = curr.next;
                dmyCurr2 = dmyCurr2.next;
            }
        }
        
        dmyCurr2.next = null;
        dmyCurr1.next = dummy2.next;
        return dummy1.next;
    }
}