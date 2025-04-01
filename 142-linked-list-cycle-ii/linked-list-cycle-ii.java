/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) {
            return null;
        }
        Map<ListNode , Integer> map = new HashMap<>();
        ListNode i = head;
        

        while(i.next!=null) {

            if(map.containsKey(i)) {
                return i;
            }
            else {
                map.put(i , 1);
            }
            i=i.next;
            
        }

        return null;
    }
}