class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(head==null || head.next==null) {
            return head;
        }

        ListNode dummy = new ListNode(0 , head);
        
        int count = 1 ;
        ListNode cur = dummy;

        while(count < left) {
            cur = cur.next;
            count++;
        }
        ListNode beforReverse = cur;
        ListNode current = cur.next;
        ListNode prev = null;
        ListNode next = null;
        int count1 = 1;

        while(count1 <= (right - left + 1)) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count1++;

        }

        beforReverse.next.next = current;
        beforReverse.next = prev;
        return dummy.next;
    }
}