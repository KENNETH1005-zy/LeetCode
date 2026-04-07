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
    public ListNode swapPairs(ListNode head) {
        //change the current not with its next, if next is not null
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        //dfs to find the next head
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
}