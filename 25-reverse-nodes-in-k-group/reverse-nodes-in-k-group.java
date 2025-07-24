class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        while (true) {
            
            ListNode temp = curr;
            int count = 0;
            while (count < k && temp.next != null) {
                temp = temp.next;
                count++;
            }
            if (count < k) break; 

           
            ListNode beforeRev = curr;
            ListNode current = curr.next;
            ListNode prev = null;
            ListNode next = null;

            
            count = 0;
            while (count < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            
            ListNode tail = beforeRev.next; 
            beforeRev.next = prev;
            tail.next = current;

            curr = tail;
        }

        return dummy.next;
    }
}
