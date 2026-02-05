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
    public ListNode reverseKGroup(ListNode head, int k) {
        //every k node reverse once
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pivot = dummy;
        while (pivot != null) {
            ListNode tracker = pivot;

            for (int i = 0; i<k; i++) {
                if (tracker == null) break;
                tracker = tracker.next;
            }
            if (tracker == null) break;
            ListNode[] pair = reverse(pivot.next, k);
            ListNode first = pair[0];
            ListNode firstNext = pair[1];

            ListNode lastOne = pivot.next;
            lastOne.next = firstNext;
            pivot.next = first;
            pivot = lastOne;
        }
        return dummy.next;
    }
    //helper function to reverse the nodes
    public ListNode[] reverse(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        
        for (int i = 0; i<k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{prev, curr};
    }
}