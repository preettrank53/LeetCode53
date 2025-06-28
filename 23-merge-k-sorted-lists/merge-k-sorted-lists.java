class Solution {

    ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            l1.next = merge2List(l1.next, l2);
            return l1;
        } else {
            l2.next = merge2List(l1, l2.next);  // Note: l1 and l2 are swapped here
            return l2;
        }
    }

    ListNode partitionAndMerge(int start, int end, ListNode[] lists) {
        if (start == end)
            return lists[start];

        if (start > end)
            return null;

        int mid = start + (end - start) / 2;

        ListNode l1 = partitionAndMerge(start, mid, lists);
        ListNode l2 = partitionAndMerge(mid + 1, end, lists);

        return merge2List(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        return partitionAndMerge(0, lists.length - 1, lists);
    }
}
