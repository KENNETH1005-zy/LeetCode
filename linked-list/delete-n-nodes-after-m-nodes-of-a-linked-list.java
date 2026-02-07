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
        ListNode prev = head;
        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            prev = curr;
            while (count < m && curr != null) {
                prev = curr;
                count += 1;
                curr = curr.next;
            }
            count = 0;
            while (count < n && curr != null) {
                count += 1;
                curr = curr.next;
            }
            count = 0;
            prev.next = curr;
        }
        return head;
    }
}