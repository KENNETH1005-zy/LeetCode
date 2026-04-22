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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        //keep m, remove n nodes
        int count = 0;
        ListNode curr = head;
        ListNode prev = head;

        while (curr != null) {
            //jump to find the m + 1 node
            while (count < m && curr != null) {
                prev = curr;
                curr = curr.next;
                count += 1;
            }
            count = 0;
            while (count < n && curr != null) {

                curr = curr.next;
                count += 1;
            }
            count = 0;
            prev.next = curr;
        }
        return head;
    }
}