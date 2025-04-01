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
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode current = slow;

        while (current!=null) {
            ListNode next = current.next;
            current.next=prev;

            prev=current;
            current=next;

        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev; // prev is now the head of reversed second half

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;




    }
}