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
        //count to record the index of the node
        //ptr listnode to determine the node after the kth node
        //which is next group's head
        //while count < k move the pointer
        //once find count == k
        //do the the reverse function
        //make head.next to the new reverseKgroup head
        //return the reversed head
        //else return the head, means, there is not enough k nodes
        int count = 0;
        ListNode ptr = head;

        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            ListNode reversedHead = reverse(head, k);
            head.next = reverseKGroup(ptr, k);
            return reversedHead;
        }
        return head;
    }
    public ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode ptr = head;
        while (k > 0) {
            ListNode next = ptr.next;
            ptr.next = prev;

            //jump
            prev = ptr;
            ptr = next;
            k--;
        }
        return prev;
    }
}