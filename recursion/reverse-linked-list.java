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
    public ListNode reverseList(ListNode head) {
        //Recursion:
        //if the head is null, or the next is null, return the current head
        if (head == null || head.next == null) {
            return head;
        }
        //recursively find the last one in thelist
        ListNode p = reverseList(head.next);
        //now p is pointing to the last node of the original node
        //make the current head's next, which is the next one in the prev list, 
        //make its next to the head
        head.next.next = head;
        //and make current next is null, because remove the prev connection
        head.next = null;
        //back to last recursion
        return p;
    }
}