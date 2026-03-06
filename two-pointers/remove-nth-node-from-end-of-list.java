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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //create a dymmy head
        //find the node from the beginning
        //find the one before the target node
        //make prev node next to the next of the next node
        //return dummy.next
        //calculate the size
        //make a dummy head if the head is to be eliminated
        //from start it is size - n + 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size += 1;
            node = node.next;
        }
        size -= n;
        node = dummy;
        while (size > 0) {
            size--;
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }
}