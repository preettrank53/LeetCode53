class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;
        while(p1 != null || p2 != null) {
            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;

            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            temp.next = new ListNode(digit);
            temp = temp.next;

            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }

        if(carry > 0) {
            temp.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
