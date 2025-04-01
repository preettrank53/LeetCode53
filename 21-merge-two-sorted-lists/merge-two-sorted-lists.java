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

                    //here we use two pointer approaches !!!!!!

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode current = p;

        while(l1!=null && l2!=null) {
            if(l1.val <= l2.val) {
                current.next=l1;
                l1=l1.next;
            }

            else{
                current.next=l2;
                l2=l2.next;
            }

            current=current.next;
        }

        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }

        return p.next;


    }
}