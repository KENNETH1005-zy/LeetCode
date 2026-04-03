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
        //iteration
        //dummy head to represent a node before the head
        //use it as the prev node
        //while head and head.next are both not null
        //return dummy.next
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;

            //jump
            prev = first;
            head = first.next;
        }
        return dummy.next;
    }
}