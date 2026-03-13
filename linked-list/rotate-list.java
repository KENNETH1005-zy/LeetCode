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
    public ListNode rotateRight(ListNode head, int k) {
        //count the length of list n
        //make the list to a circular list
        //use k % n, if == 0 return the original head
        //go through n - k% n
        //split at that point, make prev.next = null, nextStart is head
        //return nextStart
        if (head == null || k == 0) return head;
        int n = 1;
        ListNode curr = head;
        while(curr.next != null) {
            n++;
            curr = curr.next;
        }
        

        k %= n;
        if (k == 0) return head;
        curr.next = head;
        n = n - k;
        
        ListNode nextHead = head;
        ListNode prev = head;
        while (n > 0) {
            prev = nextHead;
            nextHead = nextHead.next;
            n--;
        }
        prev.next = null;
        return nextHead;
    }
}