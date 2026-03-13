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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        //use a dummy head
        //while k>0
        //every time find the node's next is null, make it as the dummy next
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        while (k>0) {
            if (curr.next == null) {
                ListNode temp = dummy.next;
                dummy.next = curr;
                curr.next = temp;
                prev.next = null;
                k--;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}