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
        //reverse the linked list for as the another list
        //add up the twin
        //remain the max along the way
        //return the max
        int max = Integer.MIN_VALUE;
        ListNode reverse = head;
        ListNode prev = null;
        int count = 0;
        while (reverse != null) {
            count++;
            ListNode next = reverse.next;
            reverse.next = prev;
            prev = reverse;
            reverse = next;
        }
        //now prev is the head of the reversed list
        int index = 0;
        while (index < count /2) {
            int sum = head.val + prev.val;
            if (sum > max) {
                max = sum;
            }
            index++;
        }
        return max;
    }
}