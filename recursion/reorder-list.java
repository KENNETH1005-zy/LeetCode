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
    public void reorderList(ListNode head) {
        //1 -> n -> 2 -> n-1 ...
        //find the middle of the list, which is the last node after reordering
        //iterate the order from the begining again
        //make the even index(1-based) to the last one
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half
        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //merge two list
        ListNode second = prev;
        ListNode first = head;
        while (second.next != null) {
            ListNode next = first.next;
            first.next = second;
            first = next;

            next = second.next;
            second.next = first;
            second = next;
            
        }
    }
}