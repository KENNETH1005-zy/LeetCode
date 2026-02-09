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
        //create a min Heap
        //add all nodes into it
        //poll until empty
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list: lists) {
            while (list != null) {
                pq.add(list);
                list = list.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }

        ListNode result = pq.poll();
        ListNode pointer = result;
        while (!pq.isEmpty()) {
            pointer.next = pq.poll();
            pointer = pointer.next;
        }
        return result;
    }
}