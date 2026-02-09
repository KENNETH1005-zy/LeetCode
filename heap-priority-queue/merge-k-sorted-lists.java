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
    public ListNode mergeKLists(ListNode[] lists) {
        //add every first head node into the pq
        //poll smallest everytime, if there is anything left in the list, add it
        if (lists.length == 0 || lists[0] == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode list: lists) {
            if (list != null)pq.add(list);
        }

        ListNode dummy = new ListNode();
        //tracker for dummy head
        ListNode tracker = dummy;
        
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tracker.next = smallest;
            tracker = tracker.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }
        return dummy.next;
    }
}