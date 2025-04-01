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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;     // first find middle of LL

        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev = null;     // Than reverse Second Half
        ListNode current = slow.next;
        slow.next=null;              //break the LL

        while(current!=null) {
            ListNode next = current.next;
            current.next=prev;

            prev=current;
            current=next;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev;

        ListNode p = new ListNode(0);  // this concept is like merge two LL , leetcode 21
        ListNode current1 = p;

        while (firstHalf != null || secondHalf != null) {
            if (firstHalf != null) {
                current1.next = firstHalf;
                current1 = current1.next;
                firstHalf = firstHalf.next;
            }
            if (secondHalf != null) {
                current1.next = secondHalf;
                current1 = current1.next;
                secondHalf = secondHalf.next;
            }
        }

        
        // Fix Cycle: Ensure last node's next is null
        current1.next = null;
        head=p.next;

        
    }
}