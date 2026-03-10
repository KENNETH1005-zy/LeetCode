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
    public int pairSum(ListNode head) {
        //using slow and fast pointers to not destroy the origianl list
        //slow is the head of the second half
        //reverse the second half
        //add up the twins to find the max one
        int max = Integer.MIN_VALUE;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode second = prev;
        curr = head;
        while (second != null) {
            max = Math.max(max, second.val + curr.val);
            second = second.next;
            curr = curr.next;
        }
        return max;
    }
}